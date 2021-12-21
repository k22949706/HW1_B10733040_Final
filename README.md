基本要求 (沒有扣 30)
	切 Activity: 
登入、註冊、主頁面和功能的切換都是切 Activity。
	Fragment Navigation 切 fragment:
藍芽頁面與詳細資料頁面是透過Navigation切fragment的。
	RecylerView:
藍芽掃描頁的掃描資料就是用RecylerView呈現，除此之外，已儲存的裝置頁面也是用RecylerView。

功能要求 (沒有扣 10)
	要用到某種權限 (敏感權限):
會要求取得手機位置權限及藍芽權限。
	結合 Firebase Auth:
用Firebase Auth實作註冊、登入、登出功能。
	要存取資料庫:
使用Room資料庫儲存藍芽資料。
	Safe argument 做資料的拋轉:
當使用者從藍芽掃描頁面進到詳細資料頁面時，就是用Safe argument傳資料。
	會做通知:
當使用者進到藍芽掃描頁或已儲存的裝置頁的時候，會分別出現不同的notification提示使用者如何操作。

進階選項 (三選一即可) (沒有扣 5)
◼ 使用 implicit intent 呼叫系統元件
	接收 broadcast: 使用broadcast receiver去判斷使用者手機是否連上網路，並且跳出toast提示。
◼ 使用系統的服務
 
品質要求
	可以跑 (沒有扣 100):
測試過在模擬器和手機上皆可正常運行。
	有 bug (看情節輕重扣分):
已修正遇過的bug，目前測試下來沒有發現新的bug了。
	旋轉畫面不會有生命週期問題 (沒有扣 50):
在Android Manifest的<activity>中加入「android:configChanges="orientation"」以防止畫面旋轉時activity重啟導致crush，並且也確認過無論是直橫畫面，app功能皆可正常運行。

額外加分項目
◼ 用到 PreferenceFragment (20)
? 功能很有創意且有意義 (10+)
◼ 整合測試 (10+)

繳交要求
文件 (沒有扣 100)
	功能介紹
	檢查表
	程式碼 (沒有扣 100)
