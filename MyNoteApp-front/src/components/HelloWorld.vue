<template>
  <h1>{{ msg }}</h1>

  <div class="card">
    <button type="button" @click="count++">count is {{ count }}</button>
    <button type="button" @click="getPageRequest()">
      {{ baseFrame.titleContent }}
    </button>
    <button type="button" @click="test()">testButton</button>
  </div>
  <div v-for="f in frames">
    <div v-for="c in f.childContents">
      <p>{{ c.body }}</p>
    </div>
  </div>
  <p>{{ createdDate }}</p>
  <p>
    Edit
    <code>components/HelloWorld.vue</code> to test HMR
  </p>
  <p>
    Check out
    <a href="https://vuejs.org/guide/quick-start.html#local" target="_blank">create-vue</a
    >, the official Vue + Vite starter
  </p>
  <p>
    Install
    <a href="https://github.com/vuejs/language-tools" target="_blank">Volar</a>
    in your IDE for a better DX
  </p>
  <p class="read-the-docs">Click on the Vite and Vue logos to learn more</p>
  <div id="app">
    <div
      v-for="(item, index) in list"
      :key="index"
      :id="item.id"
      @dragstart="dragStart($event, item.id, item.content)"
      @dragover.prevent
      @drop="drop($event, item.id, item.content)"
      draggable="true"
    >
      {{ item.content }}
    </div>
  </div>
</template>

<script>
import { ref, nextTick } from "vue";
import axios from "axios";
import LeaderLine from "vue3-leaderline";
const count = ref(0);
export default {
  setup() {
    const list = ref([
      { id: "item1", content: "Item 1" },
      { id: "item2", content: "Item 2" },
      { id: "item3", content: "Item 3" },
      { id: "item4", content: "Item 4" },
      { id: "item5", content: "Item 5" },
      { id: "item6", content: "Item 6" },
      { id: "item7", content: "Item 7" },
      { id: "item8", content: "Item 8" },
      // 他の要素...
    ]);
    const point = (p) => {
      switch (p) {
        case "Item 1":
          return { x: "0%", y: "0%" };
        case "Item 2":
          return { x: "0%", y: "50%" };
        case "Item 3":
          return { x: "0%", y: "100%" };
        case "Item 4":
          return { x: "50%", y: "0%" };
        case "Item 5":
          return { x: "50%", y: "100%" };
        case "Item 6":
          return { x: "100%", y: "0%" };
        case "Item 7":
          return { x: "100%", y: "50%" };
        case "Item 8":
          return { x: "100%", y: "100%" };
      }
    };

    let dragItemId = null;
    let from = null;
    let to = null;

    const dragStart = (event, id, fromPoint) => {
      dragItemId = id;
      from = fromPoint;
      console.log("start");
      console.log(dragItemId);
    };

    const drop = (event, dropItemId, toPoint) => {
      console.log("drop");
      console.log(dropItemId);
      nextTick(() => {
        const dragElement = document.getElementById(dragItemId);
        const dropElement = document.getElementById(dropItemId);
        to = toPoint;
        console.log("end");
        console.log(dragElement);
        console.log(dropElement);
        console.log(to);
        console.log(point(to));

        new LeaderLine(
          LeaderLine.pointAnchor(dragElement, point(from)),
          LeaderLine.pointAnchor(dropElement, point(to))
          // LeaderLine.pointAnchor(dragItemId),
          // LeaderLine.pointAnchor(dropItemId)
        );
      });
    };
    return { list, dragStart, drop };
  },
  props: {
    msg: String,
  },
  data() {
    return {
      count: 0,
      baseFrame: {},
      createdDate: new Date(),
      frames: [{}],
    };
  },
  mounted() {
    this.getPageRequest();
  },
  methods: {
    getPageRequest() {
      axios
        .get("http://localhost:8080/1")
        .then((response) => {
          console.log(response.data);
          this.createdDate = response.data.createdDate;
          this.baseFrame = response.data.page.baseFrame;
          this.frames = this.baseFrame.childFrames;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    test() {
      console.log("frames");
      console.log(this.frames);
      console.log("contents");
      console.log(this.frames[0].childContents[0].body);
    },
  },
};
</script>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
