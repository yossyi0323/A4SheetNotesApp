<template>
  <div class="frame">
    <div class="one-col-layout one-row-layout frame-area">
      <ContentView
        v-for="(content, index) in contents"
        :ref="getContentRef(index)"
        :key="index"
        :row="content.row"
        :memo="content.memo"
        @addNew="addNewContentView(index)"
      >
      </ContentView>
    </div>

    <div class="three-col-layout three-row-layout">
      <textarea v-model="fact" class="three-col three-row"></textarea>

      <textarea v-model="issue" class="three-col three-row"></textarea>

      <textarea v-model="solution" class="three-col three-row"></textarea>
    </div>

    <button @click="saveMemo">保存</button>
  </div>
</template>

<script>

import axios from 'axios'

import ContentView from './ContentView.vue'

// import marked from 'marked'

export default {

created: function () {

axios.get('http://localhost:8081/')

.then(response => {

console.log(response.data); // Greetings from API Server!

console.log('Greetings from Spring Boot!');

this.memo = response.data;

});

},

data() {

return {

contents: [{

row: 1,

memo: ''

}],

newContent: '', // 新しいコンテンツの入力値

goal: '',

fact: '',

issue: '',

solution: '',

userId: '',

username: '',

passwordHash: ''

// ,input: marked('# hello')

};

},

// computed: {

//   compiledMarkdown: function () {

//     return marked(this.input)

//   }

// },

methods: {

getContentRef(index) {

return ContentView_${index};

},

simulateTabKey() {

document.dispatchEvent(new KeyboardEvent('keydown', { key: 'Tab' }));

},

addNewContentView(index) {

console.log('addNewContentView 引数' + index)

this.contents.splice(index + 1, 0, { row: index + 1, memo: '' });

// this.$nextTick(() => {

//   console.log('newTextBox')

//   console.dir(newTextBox);

//   this.contents[index + 1];

//   const newTextBox = this.$refs[ContentView_${index + 1}];

//   console.log('ContentView_${index + 1}' + ContentView_${index + 1})

//   console.log('newTextBox')

//   console.dir(newTextBox);

//   newTextBox.$refs['content'].focus();

//   if (newTextBox) {

//     // dispatchEvent(new KeyboardEvent('keydown', { key: 'Tab' }));

//   }

//   this.simulateTabKey();

// })

},

saveMemo() {

// APIにデータを送信する処理を実装する

// ここではaxiosを使用してPOSTリクエストを送信する例を示します

axios.post('http://localhost:8081/snd-memo', { memo: this.memo })

.then(response => {

console.log('メモが保存されました:', response.data);

// メモの保存が成功した場合の処理を追加する

})

.catch(error => {

console.error('メモの保存中にエラーが発生しました:', error);

// メモの保存が失敗した場合の処理を追加する

});

},

addUser() {

// APIにデータを送信する処理を実装する

// ここではaxiosを使用してPOSTリクエストを送信する例を示します

let param = {

userId: this.userId,

username: this.username,

passwordHash: this.passwordHash

};

axios.post('http://localhost:8081/add-user', param)

.then(response => {

console.log('ユーザー情報が保存されました:', response.data);

// ユーザー情報の保存が成功した場合の処理を追加する

})

.catch(error => {

console.error('ユーザー情報の保存中にエラーが発生しました:', error);

// ユーザー情報の保存が失敗した場合の処理を追加する

});

}

},

components: { ContentView }

}
</script>

<style>
@media (min-width: 1024px) {
  .frame-area {
    flex-direction: column;
  }

  .frame {
    min-height: 100vh;

    display: flex;

    align-items: flex-start;

    flex-direction: column;
  }

  .three-col {
    flex: 1;
  }

  .three-col-layout {
    display: flex;

    flex-wrap: wrap;
  }

  .three-row {
    height: 80vh;
  }

  .three-row-layout {
    display: flex;

    height: 80vh;

    width: 100vw;
  }

  .one-col {
    width: 100vw;
  }

  .one-col-layout {
    display: flex;

    width: 100%;

    max-width: 100vw;
  }

  .one-row {
    height: 15vh;
  }

  .one-row-layout {
    display: flex;

    height: 15vh;

    max-height: 15vh;
  }
}
</style>
