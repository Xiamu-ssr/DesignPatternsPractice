适配器模式。

有三个市场，分别为美国、欧洲、亚洲。当我们想获取一个股票的价格时，希望用同样的接口获取，并且只需要提供股票代码即可。

但是三个市场返回的数据结构并不一样，分别是json、xml、api。

所以我们为三个市场制定适配器，使得大家都直接返回price。


![](../../../../../../images/2-1.png)