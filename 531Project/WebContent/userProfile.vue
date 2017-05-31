<template>
  <div class="user-pane">
    < div class="user-profile">
      <img v-bind:src="avatarLink" class="avatar" alt="user-avatar" />
      <h3 class="user-name">{{ name }}</h3>
  </div>
  <p id="display">
    {{ display }}
  </p>
  </div>
</template>

<script>
export default {
  name: 'userProfile',
  props: {
    name: string,
    avatarLink: string
  },
  computed: {
    display: function () {
      return test;
    }
  }
}
</script>
