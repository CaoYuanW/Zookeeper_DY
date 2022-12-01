package day01;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;


public class Demo06 {
    public static void main(String[] args) throws Exception {

        // 创建Zookeeper对象
        final ZooKeeper zk = new ZooKeeper("linux01:2181", 2000, null);

        //节点个数变化监听
        List<String> children = zk.getChildren("/", new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType());
                try {
                    List<String> children1 = zk.getChildren("/", this);
                    System.out.println("变化后节点下节点名称为：" + children1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("当前节点下节点名称为：" + children);
        Thread.sleep(Integer.MAX_VALUE);

        // 关闭连接
        zk.close();
    }
}
