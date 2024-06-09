<template>
  <div class="content">
    <div class="content-area">
      <textarea
        v-model="content"
        ref="content"
        :style="styles"
        class="content-input-area content-col content-row"
        @keydown.enter="addNew"
      ></textarea>
    </div>
  </div>
</template>

<script>
import axios from "axios";

// import marked from 'marked'

export default {
  created() {
    // axios.get('http://localhost:8081/')
    //   .then(response => {
    //     console.log(response.data) // Greetings from API Server!
    //     console.log('Greetings from Spring Boot!')
    //     this.memo = response.data
    //   })
  },

  props: {
    memo: {
      type: String,

      default: "",
    },

    row: {
      type: Number,
    },
  },

  data() {
    return {
      lineCount: this.row,

      content: this.memo,

      goal: "",

      fact: "",

      issue: "",

      solution: "",

      userId: "",

      username: "",

      passwordHash: "",

      height: "20px",

      // content: '',

      newContent: "", // 新しいコンテンツの入力値

      // ,input: marked('# hello')
    };
  },

  // computed: {

  //   compiledMarkdown: function () {

  //     return marked(this.input)

  //   }

  // },

  mounted() {
    this.resize();

    console.log(this.getRow());

    this.focus();
  },

  watch: {
    "content.memo"() {
      this.resize();
    },
  },

  computed: {
    styles() {
      return {
        height: this.height,
      };
    },
  },

  methods: {
    addNew(event) {
      if (event.metaKey) {
        // Commandキーが押されているかを確認

        // event.preventDefault(); // デフォルトの動作をキャンセル

        this.$emit("addNew"); // 親コンポーネントにaddNewイベントを発生させる
      }

      this.simulateTabKey();
    },

    simulateTabKey() {
      document.dispatchEvent(new KeyboardEvent("keydown", { key: "Tab" }));
    },

    focus() {
      this.$refs.content.focus();
    },

    getRow() {
      return this.content.row;
    },

    resize() {
      this.height = "auto";

      this.$nextTick(() => {
        if (this.$refs.content.scrollHeight) {
          this.height = this.$refs.content.scrollHeight + "px";
        }
      });
    },

    saveMemo() {
      // APIにデータを送信する処理を実装する

      // ここではaxiosを使用してPOSTリクエストを送信する例を示します

      axios
        .post("http://localhost:8081/snd-memo", { memo: this.memo })

        .then((response) => {
          console.log("メモが保存されました:", response.data);

          // メモの保存が成功した場合の処理を追加する
        })

        .catch((error) => {
          console.error("メモの保存中にエラーが発生しました:", error);

          // メモの保存が失敗した場合の処理を追加する
        });
    },

    addUser() {
      // APIにデータを送信する処理を実装する

      // ここではaxiosを使用してPOSTリクエストを送信する例を示します

      let param = {
        userId: this.userId,

        username: this.username,

        passwordHash: this.passwordHash,
      };

      axios
        .post("http://localhost:8081/add-user", param)

        .then((response) => {
          console.log("ユーザー情報が保存されました:", response.data);

          // ユーザー情報の保存が成功した場合の処理を追加する
        })

        .catch((error) => {
          console.error("ユーザー情報の保存中にエラーが発生しました:", error);

          // ユーザー情報の保存が失敗した場合の処理を追加する
        });
    },
  },
};
</script>

<style>
@media (min-width: 1024px) {
  /* .content-input-area {
  
  background-color: gray;
  
  } */

  .content {
    width: 100%;

    /* min-height: 100vh;
  
  display: flex;
  
  align-items: flex-start;
  
  flex-direction: column; */
  }

  .three-col {
    flex: 1;
  }

  .three-col-layout {
    display: flex;

    flex-wrap: wrap;
  }

  .content-area {
    width: 100%;
  }

  .three-row {
    height: 80vh;
  }

  .three-row-layout {
    display: flex;

    height: 80vh;

    width: 100vw;
  }

  .content-col {
    width: 100%;

    field-sizing: content;
  }

  .one-col-layout {
    display: flex;

    max-width: 100vw;
  }

  .content-row {
    /height: auto;
    /min-height: 20px;

    max-height: max-content;
  }

  .one-row-layout {
    display: flex;

    max-height: max-content;
  }
}
</style>
