var userProfile = {
  props: ['name', 'avatar'],
  template: '<div class="user-pane">
  < div class="user-profile" >
  <img v-bind:src="avatarLink" class="avatar" alt="user-avatar" />
  <h3 class="user-name">{{ name }}</h3>
  </div >
  <p id="display">
    {{ display }}
  </p>
  </div > ',
computed: {
  display: function () {
    return test;
  }
}

}