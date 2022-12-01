package day01;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;


public class Demo07 {
    public static void main(String[] args) throws Exception {

        // 创建Zookeeper对象
        ZooKeeper zk = new ZooKeeper("linux01:2181", 2000, null);

        //删除节点
        zk.delete("/aaa",-1);

        // 关闭连接
        zk.close();
    }
}
