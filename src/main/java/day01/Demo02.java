package day01;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;


public class Demo02 {
    public static void main(String[] args) throws Exception {

        // 创建Zookeeper对象
        ZooKeeper zk = new ZooKeeper("linux01:2181", 2000, null);

        //获取节点下子节点的名字
        List<String> children = zk.getChildren("/config", null);
        for (String child : children) {
            System.out.println("/config/" + child );
        }

        // 关闭连接
        zk.close();
    }
}
