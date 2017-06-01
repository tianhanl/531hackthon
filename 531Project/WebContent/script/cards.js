// This script will add all the available cards to the vue global space
const EmptyCardContent = {
  template: '<div class="option-board" v-on:mouseover="mouseHover=true" v-on:mouseleave="mouseHover=false"><div v-if="mouseHover" ><button v-for="option in options" @click="changeType(option)">{{option}}</button></div></div> ',
  props: ['options'],
  data: function () {
    return {
      mouseHover: false
    };
  },
  methods: {
    changeType: function (typeToChange) {
      this.$emit('typechange', typeToChange);
    }
  }
};

const ZhihuCardContent = {
  template: '<div><div class="card-head"><h2 class="card-name">Zhihu Daily</h2></div> <div class="card-content" ><h3>Top Stories:</h3><a v-for="article in articleList" :href="article.url" target="_blank">{{article.title}}</a></div></div>',
  computed: {
    articleList: function () {
      var list = [];
      var resData = {
        date: "20140523",
        stories: [
          {
            title: "中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）",
            ga_prefix: "052321",
            images: [
              "http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"
            ],
            type: 0,
            id: 3930445
          },
        ],
        top_stories: [
          {
            title: "商场和很多人家里，竹制家具越来越多（多图）",
            image: "http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg",
            ga_prefix: "052315",
            type: 0,
            id: 3930883
          }
        ]
      };
      var topStories = resData.top_stories;
      topStories.forEach(function (element) {
        let story = {};
        story.title = element.title;
        story.url = 'https://daily.zhihu.com/story/' + element.id;
        list.push(story);
      });

      return list;
    }
  }
};

const ClockCardContent = {
  template: '<div><div class="card-head"><h2 class="card-name">Clock</h2></div> <div class="card-content" >{{currentTime}}</div></div>',
  data: function () {
    return {
      currentHour: new Date().getHours(),
      currentMinute: new Date().getMinutes()
    };
  },
  computed: {
    currentTime: function () {
      return '' + this.currentHour + ':' + this.currentMinute;
    }
  },
  methods: {
    setUpdateTime: function () {
      var that = this;
      setInterval(function () {
        that.updateTime();
      }, 60000);
    },
    updateTime: function () {
      this.currentMinute++;
      if (this.currentMinute >= 60) {
        this.currentMinute -= 60;
        this.currentHour++;
        if (this.currentHour >= 24) {
          this.currentHour -= 24;
        }
      }
    }
  },
  created: function () {
    this.setUpdateTime();
  }
};
Vue.component('empty-card-content', EmptyCardContent);
Vue.component('zhihu-card-content', ZhihuCardContent);
Vue.component('clock-card-content', ClockCardContent);