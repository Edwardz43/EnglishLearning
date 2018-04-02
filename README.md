# EnglishLearning
背英文單字用的APP 幫老婆做的

看到老婆在背英文單字  她把遇到的生字記在excel 存放在google drive 
還寫了巨集測試自己會不會拼
我就想到可以用手機寫一隻app來實現這個功能

詳細內容參考:
https://www.crazycodersclub.com/android/using-google-spread-sheet-as-database-for-android-application-part-1/

大致上就是 將excel檔透過google drive發佈到網路上  
再利用Google app script的服務 讓手機端可以用requset的方式取得JSON格式的excel檔內容
再將取到的單字列表用作測驗
