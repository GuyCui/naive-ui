package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;

/**
 * @className: NettyClient
 * @description: Netty客户端
 * @author: GuyCui
 * @date: 2021/9/3
 **/
public class NettyClient {
    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1",7397);
    }

    /**
     * Netty 启动客户端的基本模型代码，传输 IP 与端口，数据交给 handler 处理
     * @param inetHost
     * @param inetPort
     */
    private void connect(String inetHost, int inetPort) {
        // 一个事件循环组，用于处理通信管道数据
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            // 用于处理待创建Channel所有事件
            b.group(workerGroup);
            // 用于从中创建Channel实例的Class
            b.channel(NioSocketChannel.class);
            // 允许指定一个ChannelOption ，一旦它们被创建， ChannelOption用于Channel实例。 使用null值
            b.option(ChannelOption.AUTO_READ, true);
            // 主要承担着通信数据的业务行为
            b.handler(new MyChannelInitializer());
            ChannelFuture future = b.connect(inetHost, inetPort).sync();
            future.channel().closeFuture().sync();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        } finally {
            // 它的监听管道关闭操作
            workerGroup.shutdownGracefully();
        }
    }

}
