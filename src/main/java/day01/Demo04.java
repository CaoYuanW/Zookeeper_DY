package day01;

import org.apache.zookeeper.ZooKeeper;


public class Demo04 {
    public static void main(String[] args) throws Exception {

        // 创建Zookeeper对象
        ZooKeeper zk = new ZooKeeper("linux01:2181", 2000, null);

        //更新节点的值
        zk.setData("/aaa","a".getBytes(),-1);

        // 关闭连接
        zk.close();
    }
}
