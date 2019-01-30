package com.example.admin.myapplication.Model

class InfoBean {

    /**
     * date : 20190127
     * stories : [{"images":["https://pic4.zhimg.com/v2-f1fcb68c2e179722a27767197e298d5b.jpg"],"type":0,"id":9706906,"ga_prefix":"012712","title":"「北大毕业送外卖」刷屏之后，我们和作者聊了聊"},{"images":["https://pic2.zhimg.com/v2-ca9864af718af16aa7c0056607f2c0d1.jpg"],"type":0,"id":9706914,"ga_prefix":"012712","title":"大误 · 女朋友把发箍带男朋友手上是什么意思？"},{"images":["https://pic1.zhimg.com/v2-2b9d1ecea1475e83488943f5f1b3d6f8.jpg"],"type":0,"id":9706797,"ga_prefix":"012710","title":"第一批 5G 手机要上市了，读完这篇再想想要不要尝鲜"},{"images":["https://pic1.zhimg.com/v2-8e6bf6e350ee8761eaa6d661a5674d2c.jpg"],"type":0,"id":9706819,"ga_prefix":"012710","title":"上吊时如果后悔了，能否靠臂力把自己抬起来自救？"},{"images":["https://pic3.zhimg.com/v2-e1f1542719d912b2b09b14326db179ae.jpg"],"type":0,"id":9704923,"ga_prefix":"012708","title":"我炫富，我开心"},{"images":["https://pic2.zhimg.com/v2-0bdce68ac4fb7b6a7f6bdecb31f60621.jpg"],"type":0,"id":9706622,"ga_prefix":"012707","title":"煮一锅红豆沙，暖暖的甘甜化在嘴里，很治愈"},{"images":["https://pic1.zhimg.com/v2-4d0ac8202feedb386402fb08426aec7c.jpg"],"type":0,"id":9706672,"ga_prefix":"012707","title":"嗯哼，Rap 与「麻辣鸡丝」"},{"images":["https://pic1.zhimg.com/v2-402447164fcb14fc9396d05e694f1068.jpg"],"type":0,"id":9706780,"ga_prefix":"012706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-c7e371e7149e36ac263c8b49744ef2f9.jpg","type":0,"id":9706906,"ga_prefix":"012712","title":"「北大毕业送外卖」刷屏之后，我们和作者聊了聊"},{"image":"https://pic2.zhimg.com/v2-dcb28aefa65522bc646ca565b207d335.jpg","type":0,"id":9706797,"ga_prefix":"012710","title":"第一批 5G 手机要上市了，读完这篇再想想要不要尝鲜"},{"image":"https://pic3.zhimg.com/v2-3baa33837f544133346dbb5de587c2a2.jpg","type":0,"id":9706845,"ga_prefix":"012621","title":"《歌手》第三期：有人献上神作，有人被饭圈「陷害」"},{"image":"https://pic1.zhimg.com/v2-81a5b79d653390aec0f0cbb39f605c04.jpg","type":0,"id":9706810,"ga_prefix":"012619","title":"解压，当代新玄学"},{"image":"https://pic1.zhimg.com/v2-6231f8309b15501f9ebf81754ed63834.jpg","type":0,"id":9706804,"ga_prefix":"012616","title":"用 iPhone XS 拍摄的《一个桶》，是一部好电影吗？"}]
     */

    var date: String? = null
    var stories: List<StoriesBean>? = null
    var top_stories: List<TopStoriesBean>? = null

    class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-f1fcb68c2e179722a27767197e298d5b.jpg"]
         * type : 0
         * id : 9706906
         * ga_prefix : 012712
         * title : 「北大毕业送外卖」刷屏之后，我们和作者聊了聊
         */

        var type: Int = 0
        var id: Int = 0
        var ga_prefix: String? = null
        var title: String? = null
        var images: List<String>? = null
    }

    class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-c7e371e7149e36ac263c8b49744ef2f9.jpg
         * type : 0
         * id : 9706906
         * ga_prefix : 012712
         * title : 「北大毕业送外卖」刷屏之后，我们和作者聊了聊
         */

        var image: String? = null
        var type: Int = 0
        var id: Int = 0
        var ga_prefix: String? = null
        var title: String? = null
    }
}
