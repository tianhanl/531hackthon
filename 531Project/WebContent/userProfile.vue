<template>
  <div class="user-pane">
    <div class="user-profile">
      <img class="user-avatar" v-bind:src="avatarSrc" alt="avatar" /div>
      <h3>{{userNmae}}</h3>
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
