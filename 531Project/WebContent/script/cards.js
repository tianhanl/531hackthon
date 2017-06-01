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
      var resData;
      axios.get('/actionServlet').then(function (response) {
        resData = JSON.parse(response.data);
      }).catch(function (error) {
        console.log(error);
      });
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