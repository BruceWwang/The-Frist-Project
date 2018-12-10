package com.java.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ȩ����ѯ�����㷨(WeightedRound-RobinScheduling)-Javaʵ��
 * @author huligong
 * */
public class WeightedRoundRobinScheduling {

    private int currentIndex = -1;// ��һ��ѡ��ķ�����
    private int currentWeight = 0;// ��ǰ���ȵ�Ȩֵ
    private int maxWeight = 0; // ���Ȩ��
    private int gcdWeight = 0; //���з�����Ȩ�ص����Լ��
    private int serverCount = 0; //����������
    private List<Server> serverList; //����������

    /**
     * �������Լ��
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        BigInteger b1 = new BigInteger(String.valueOf(a));
        BigInteger b2 = new BigInteger(String.valueOf(b));
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
    
     
    /**
     * �������з�����Ȩ�ص����Լ��
     * @param serverList
     * @return
     */
    private static int getGCDForServers(List<Server> serverList ) {
        int w = 0;
        for (int i = 0, len = serverList.size(); i < len - 1; i++) {
            if (w == 0) {
                w = gcd(serverList.get(i).weight, serverList.get(i + 1).weight);
            } else {
                w = gcd(w, serverList.get(i + 1).weight);
            }
        }
        return w;
    }
    

    /**
     * �������з������е����Ȩ��
     * @param serverList
     * @return
     */
    public static int getMaxWeightForServers(List<Server> serverList) {
        int w = 0;
        for (int i = 0, len = serverList.size(); i < len - 1; i++) {
            if (w == 0) {
                w = Math.max(serverList.get(i).weight, serverList.get(i + 1).weight);
            } else {
                w = Math.max(w, serverList.get(i + 1).weight);
            }
        }
        return w;
    }
    
    /**
     *  �㷨���̣� 
     *  ������һ������� S = {S0, S1, ��, Sn-1}
     *  ����Ӧ��Ȩ�أ�����currentIndex��ʾ�ϴ�ѡ��ķ�����
     *  ȨֵcurrentWeight��ʼ��Ϊ0��currentIndex��ʼ��Ϊ-1 ������һ�ε�ʱ�򷵻� Ȩֵȡ�����Ǹ���������
     *  ͨ��Ȩ�صĲ��ϵݼ� Ѱ�� �ʺϵķ��������أ�ֱ����ѯ������Ȩֵ����Ϊ0 
     */
    public Server GetServer() {
        while (true) {
            currentIndex = (currentIndex + 1) % serverCount;
            if (currentIndex == 0) {
                currentWeight = currentWeight - gcdWeight;
                if (currentWeight <= 0) {
                    currentWeight = maxWeight;
                    if (currentWeight == 0)
                        return null;
                }
            }
            if (serverList.get(currentIndex).weight >= currentWeight) {
                return serverList.get(currentIndex);
            }
        }
    }


    class Server {
        public String ip;
        public int weight;
        public Server(String ip, int weight) {
            super();
            this.ip = ip;
            this.weight = weight;
        }
        public String getIp() {
            return ip;
        }
        public void setIp(String ip) {
            this.ip = ip;
        }
        public int getWeight() {
            return weight;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    

    public void init() {
        Server s1 = new Server("192.168.0.100", 3);//3
        Server s2 = new Server("192.168.0.101", 2);//2
        Server s3 = new Server("192.168.0.102", 6);//6
        Server s4 = new Server("192.168.0.103", 4);//4
        Server s5 = new Server("192.168.0.104", 1);//1
        serverList = new ArrayList<Server>();
        serverList.add(s1);
        serverList.add(s2);
        serverList.add(s3);
        serverList.add(s4);
        serverList.add(s5);
        
        currentIndex = -1;
        currentWeight = 0;
        serverCount = serverList.size();
        maxWeight = getMaxWeightForServers(serverList);
        gcdWeight = getGCDForServers(serverList);
    }
    
    
    public static void main(String[] args) {
        WeightedRoundRobinScheduling obj = new WeightedRoundRobinScheduling();
        obj.init();
        
        Map<String,Integer> countResult = new HashMap<String,Integer>();
        
        for (int i = 0; i < 100; i++) {
            Server s = obj.GetServer();
            String log = "ip:"+s.ip+";weight:"+s.weight;
            if(countResult.containsKey(log)){
                countResult.put(log,countResult.get(log)+1);
            }else{
                countResult.put(log,1);
            }
            System.out.println(log);
        }
        
        for(Entry<String, Integer> map : countResult.entrySet()){
            System.out.println("������ "+map.getKey()+" ��������� "+map.getValue());
        }
    }

}