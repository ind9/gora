package org.apache.gora.hbase.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HBaseTestingUtility;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestHBaseClusterCase {
    public static final Configuration conf = HBaseConfiguration.create();
    private static final HBaseTestingUtility UTIL = new HBaseTestingUtility(conf);

    @BeforeClass
    public static void bootstrap() throws Exception {
        UTIL.getConfiguration().set("dfs.datanode.data.dir.perm", "755");
        UTIL.startMiniCluster();
    }

    @AfterClass
    public static void shutdown() throws Exception {
        UTIL.shutdownMiniCluster();
    }
}
