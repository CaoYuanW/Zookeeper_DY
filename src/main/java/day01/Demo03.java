package day01;

import org.apache.zookeeper.ZooKeeper;

import java.util.List;


public class Demo03 {
    public static void main(String[] args) throws Exception {

        // 创建Zookeeper对象
        ZooKeeper zk = new ZooKeeper("linux01:2181", 2000, null);

        //获取节点的值
        byte[] data = zk.getData("/aaa", null, null);
        System.out.println(new String(data));

        // 关闭连接
        zk.close();
    }
}
