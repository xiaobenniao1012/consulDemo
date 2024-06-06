# 参考文档
https://zhuanlan.zhihu.com/p/701107409

这里的微服务用来测试consul的服务注册和发现功能

需要实现安装docker和consul，consul在容器中启动3个，然后启动微服务，微服务会注册到consul中，然后通过consul的api来获取服务的信息

访问http://localhost:8500/ui/可以看到consul的界面

访问http://localhost:8002/order/123可以看到微服务的返回信息