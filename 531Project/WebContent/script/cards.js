
const ZhihuCardContent = {
  template: '<div class="card-head"><h2 class="card-name">Zhihu Daily</h2></div> <div class="card-content" ><a v-for="article in articleList" :src="article.url">{{title}}</a></div></div>',
  computed: {
    articleList: function () {
      return [{
        title: "test",
        url: 'https://daily.zhihu.com/story/94509443930883'
      }];
    }
  }
};

const ClockCardContent = {
  template: '<div class="card" > <div class="card-head"><h2 class="card-name">Clock</h2></div> <div class="card-content" >{{currentTime}}</div>',
  computed: {
    currentTime: function () {
      return '11:15';
    }
  }
};

Vue.component('zhihu-card-content', ZhihuCardContent);
vue.component('clock-card-content', ClockCardContent);
