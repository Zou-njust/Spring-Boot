package edu.njust.algorithm;

import edu.njust.model.oracle.Relationship;
import edu.njust.service.NodeService;
import edu.njust.service.RelationshipService;
import norsys.netica.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ThreatAnalysis {
    @Autowired
    private NodeService nodeService;

    @Autowired
    private RelationshipService relationshipService;

    static private Environ env;

    static {
        try {
            env = new Environ(null);
        } catch (NeticaException e) {
            e.printStackTrace();
        }
    }

    static final public int RECONNAISSANCE = 0;
    static final public int BOMBER = 1;
    static final public int FIGHTER = 2;

    // 对应平台、武器、属性、时空、威胁
    static final private int netNum = 5;

    static final private String[] threatType = new String[]{"pingtai", "wuqi", "shuxing", "shikong", "weixie"};

    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public List<Net> getNet(){

        List<Net> netList = new ArrayList<>();

        for (int i = type * netNum; i < (type + 1) * netNum; i ++){
            Net net = null;
            try {
                List<edu.njust.model.oracle.Node> result = nodeService.findAllNodeByType(i);
                net = new Net();
                // 依次添加节点
                for (edu.njust.model.oracle.Node n : result){
                    Node node = new Node(n.getName(), n.getState(), net);

                }
                // 依次添加边
                for (edu.njust.model.oracle.Node n : result){
                    Node node = net.getNode(n.getName());
                    List<Relationship> relationships = relationshipService.findRelationshipByTo(n.getId());
                    for (Relationship relationship : relationships){
                        Node parent = net.getNode(nodeService.findNameById(relationship.getFrom()));
                        node.addLink(parent);
                    }
                }
                // 依次添加CPT
                for (edu.njust.model.oracle.Node n : result){
                    Node node = net.getNode(n.getName());

                    int cptLength = node.getNumStates();
                    NodeList parents = node.getParents();
                    for (Object p : parents){
                        Node parent = (Node)p;
                        cptLength *= parent.getNumStates();
                    }
                    if (cptLength != n.getCpt().split(",").length){
                        float[] cpt = new float[cptLength];
                        for (int c = 0; c < cptLength; c ++){
                            cpt[c] = (float)(1 / cptLength);
                        }
                    }

                    if (!n.getCpt().equals("null")){
                        String[] cptStrings = n.getCpt().split(",");
                        float[] cpt = new float[cptStrings.length];
                        for (int c = 0; c < cpt.length; c ++){
                            cpt[c] = Float.parseFloat(cptStrings[c]);
                        }
                        node.setCPTable(cpt);
                    }
                    else {
                        float[] cpt = new float[cptLength];
                        for (int c = 0; c < cptLength; c ++){
                            cpt[c] = (float)(1 / cptLength);
                        }
                    }
                }
                net.compile();
                netList.add(net);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        return netList;
    }

    public Map<String, float[]> analyze(Map<String, Object> data, List<Float> intention){
        Map<String, float[]> result = new HashMap<>();

        String[] resultNames;
        if (type == RECONNAISSANCE){
            resultNames = new String[]{"WuLiTeXing", "DianCiPingTai", "MuBiaoShuXing", "FeiXingHangXian"};
        }
        else {
            resultNames = new String[]{"WuLiTeXing", "WuQiPingTai", "MuBiaoShuXing", "FeiXingHangXian"};
        }

        try {
            List<Net> netList = getNet();

            for (int n = 0; n < netList.size(); n ++){
                Net net = netList.get(n);
                // 清空之前的数据
                for (Object o : net.getNodes()){
                    Node node = (Node)o;
                    node.finding().clear();
                }
                if (n < netNum - 1){

                    for (Map.Entry<String, Object> d : data.entrySet()){
                        Node node;
                        if ((node = net.getNode(d.getKey())) != null){
                            Object value = d.getValue();
                            if (value instanceof String){
                                if (value.equals("null")){
                                    node.finding().clear();
                                }
                                else {
                                    node.finding().enterState((String)value);
                                }

                            }
                            else if (value instanceof Integer){
                                node.finding().enterState((int)value);
                            }
                            else if (value instanceof float[]){
                                node.finding().enterLikelihood((float[])value);
                            }
                        }

                    }

                    result.put(resultNames[n], net.getNode(resultNames[n]).getBeliefs());
                }
                else {
                    for (String r : resultNames){
                        net.getNode(r).finding().enterLikelihood(result.get(r));
                    }
                    float[] intentionArray = new float[intention.size()];
                    for (int i = 0; i < intentionArray.length; i ++){
                        intentionArray[i] = intention.get(i);
                    }
                    net.getNode("RenWuShuXing").finding().enterLikelihood(intentionArray);

                    result.put("WeiXieDengJi", net.getNode("WeiXieDengJi").getBeliefs());
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public void train(List<Map<String, Integer>> data){
        try {
            List<Net> netList = getNet();
            for (int n = 0; n < netList.size(); n ++) {

                Net net = netList.get(n);

                (new File("./src/main/resources/bn/"+threatType[n]+".cas")).delete();
                for (Map<String, Integer> d : data){

                    // 清空之前的数据
                    for (Object o : net.getNodes()) {
                        Node node = (Node) o;
                        node.finding().clear();
                    }

                    for (Map.Entry<String, Integer> entry : d.entrySet()){
                        Node node;
                        if ((node = net.getNode(entry.getKey())) != null){
                            node.finding().enterState(entry.getValue());
                        }
                    }
                    net.writeFindings(new Streamer("./src/main/resources/bn/"+threatType[n]+".cas"), null, -1, -1);
                }

                // 清空之前的数据
                for (Object o : net.getNodes()) {
                    Node node = (Node) o;
                    node.finding().clear();
                    node.deleteTables();
                }

                Learner learner = new Learner(Learner.EM_LEARNING);

                Caseset caseset = new Caseset();
                caseset.addCases(new Streamer("./src/main/resources/bn/"+threatType[n]+".cas"), 1.0, null);

                learner.learnCPTs(net.getNodes(), caseset, 1.0);

                for (Object o : net.getNodes()){
                    Node node = (Node)o;

                    String CPT;
                    if (node.hasTable(null)){
                        StringBuilder cptString = new StringBuilder();
                        float[] cpt = node.getCPTable(null);
                        for (int c = 0; c < cpt.length; c ++){
                            cptString.append(cpt[c]);
                            if (c < cpt.length - 1){
                                cptString.append(',');
                            }
                        }
                        CPT = cptString.toString();
                    }
                    else {
                        CPT = "null";
                    }

//                    System.out.println(nodeService.findIdByNameAndType(node.getName(), type * netNum)+" : "+node.getName()+" : "+CPT);
                    nodeService.updateCPTByNameAndType(node.getName(), n + type * netNum, CPT);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List getNodeAndLink(){
        class TmpLink{
            public String from;
            public String to;
        }
        List<Map> resultList = new ArrayList<>();

        for (int i = type * netNum; i < (type + 1) * netNum; i ++){
            List<edu.njust.model.oracle.Node> nodeList = nodeService.findAllNodeByType(i);

            List<TmpLink> linkList = new ArrayList<>();
            for (edu.njust.model.oracle.Node node : nodeList){
                List<Relationship> relationshipList = relationshipService.findRelationshipByTo(node.getId());
                for (Relationship relationship : relationshipList){
                    TmpLink tmpLink = new TmpLink();
                    tmpLink.from = nodeService.findNameById(relationship.getFrom());
                    tmpLink.to = nodeService.findNameById(relationship.getTo());
                    linkList.add(tmpLink);
                }
            }
            Map result = new HashMap();
            result.put("node", nodeList);
            result.put("link", linkList);

            resultList.add(result);
        }


        return resultList;
    }
}
