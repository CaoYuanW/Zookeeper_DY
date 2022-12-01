package day01;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;


public class Demo05 {
    public static void main(String[] args) throws Exception {

        // 创建Zookeeper对象
        final ZooKeeper zk = new ZooKeeper("linux01:2181", 2000, null);

        //节点数据变化监听
        byte[] data = zk.getData("/aaa", new Watcher() {
            // 数值发生变化回调方法
            public void process(WatchedEvent watchedEvent) {
                try {
                    System.out.println(watchedEvent.getType());
                    byte[] data = zk.getData("/aaa", this, null);
                    System.out.println("更新后的值：" + new String(data));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null);

        System.out.println("当前/aaa节点的值是：" + new String(data));

        Thread.sleep(Integer.MAX_VALUE);

        // 关闭连接
        zk.close();
    }
}
