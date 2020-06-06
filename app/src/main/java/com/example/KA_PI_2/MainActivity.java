package com.example.KA_PI_2;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btback,btsearch;
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bundle = this.getIntent().getExtras();
        String carrier = bundle.getString("bt");
        int id = bundle.getInt("id");
        btsearch = findViewById(R.id.btsearch);
        btback = findViewById(R.id.btback);
        //判斷要哪個button 要加入那些資料
        models = new ArrayList<>();
        if (carrier.equals("coffeehunter")) {
            models.add(new Model(R.drawable.v60, "V60", getString(R.string.v60) +
                    getString(R.string.v602) +
                    "\n"));
            models.add(new Model(R.drawable.kalita, "Kalita Wave", getString(R.string.kalita) +
                    "\n" +
                    getString(R.string.kalita2)));
            models.add(new Model(R.drawable.chemx, "The Chemex", getString(R.string.chemx1) +
                    getString(R.string.chemx2)));
            models.add(new Model(R.drawable.brewers, "Batch Brewers", getString(R.string.brewers1) +
                    "\n" +
                    getString(R.string.brewers2)));
            models.add(new Model(R.drawable.smart, "聰明濾杯", getString(R.string.sma1) +
                    "\n" +
                    getString(R.string.sma2)));
            models.add(new Model(R.drawable.franch, "法式濾壓壺", getString(R.string.fr1) +
                    "\n" + getString(R.string.fr2)));
            models.add(new Model(R.drawable.lovepush, "愛樂壓", getString(R.string.l1) + "\n\n" + getString(R.string.l2) + "選愛樂壓的理由：你想要出門也能煮好咖啡，或你想要一杯簡單就可製作並具飽滿口感的咖啡。"));
            models.add(new Model(R.drawable.machine, "家用義式咖啡機", getString(R.string.m1) + "\n"
                    + getString(R.string.m2)));
            models.add(new Model(R.drawable.moka, "摩卡壺", getString(R.string.mo1) + "\n"
                    + getString(R.string.mo2)));
            models.add(new Model(R.drawable.sock, "虹吸壺", getString(R.string.soc1) +
                    "\n" +
                    getString(R.string.soc2)));
            models.add(new Model(R.drawable.turkey, "土耳其壺", getString(R.string.tur1) +
                    "\n" + getString(R.string.tur2)));
        } else if (carrier.equals("cook")) {
            models.add(new Model(R.drawable.water, "水洗處理法", getString(R.string.wat1)));
            models.add(new Model(R.drawable.sun, "日曬法", getString(R.string.sun1)));
            models.add(new Model(R.drawable.wet, "濕刨法", getString(R.string.wet1) +
                    getString(R.string.wet2)));
            models.add(new Model(R.drawable.suger, "密處理法", getString(R.string.bee1)));
            models.add(new Model(R.drawable.reds, "紅寶石處理", getString(R.string.red) +
                    "\n"));
            models.add(new Model(R.drawable.sol, "SolkilnTM特殊處理法", getString(R.string.sol)));
            models.add(new Model(R.drawable.suger2, "甘蔗法去咖啡因", ""));
        } else {
            models.add(new Model(R.drawable.american, "Americano", "美式咖啡可以說是黑咖啡的總稱。無論是法式濾壓壺或是手沖壺沖煮出的咖啡都可泛稱為美式。在義大利，美式咖啡通常就是Espresso旁邊放上一杯熱水任你添加，濃縮咖啡與水的比例視個人口味而定，大約為1:12。\n" +
                    "\n" +
                    "容量：360ml    沖泡時間：30秒    咖啡因：★★★☆☆"));
            models.add(new Model(R.drawable.latte, "Caffe Latte", "拿鐵在義大利文裡就是牛奶的意思，到義大利千萬不可直接叫拿鐵，否則服務生端來的不是咖啡，而是一杯熱牛奶。由此可見牛奶才是這杯咖啡的主角，標準比例大約是1/6濃縮咖啡、4/6熱牛奶、1/6奶泡，由於牛奶的比例高、奶泡厚重，因此口感更顯甜香且柔順細緻。\n" +
                    "\n" +
                    "容量：240ml    沖泡時間：60秒    咖啡因：★★★☆☆"));
            models.add(new Model(R.drawable.capuccino, "Cappuccino", "卡布奇諾在義大利文中指的是泡沫咖啡，同時也意指聖方濟修士寬鬆的長袍和小尖帽（如同卡布奇諾咖啡的棕色）。卡布奇諾與拿鐵咖啡的差別在於調配比例，濃縮咖啡Espresso、鮮奶與奶泡各為1：1：1，首先倒入濃縮咖啡，熱牛奶，最後鋪上一層厚重的奶泡，再灑上可可粉增添風味。\n" +
                    "\n" +
                    "容量：180ml    沖泡時間：60秒    咖啡因：★★★☆☆"));
            models.add(new Model(R.drawable.expresso, "Expresso", "使用義式咖啡機沖泡，藉由高壓水沖煮研磨細緻且緊壓的咖啡粉，比其他方法製作出來的咖啡更加濃郁，由於含有更高濃度的懸浮物，表層帶有紅棕色的咖啡脂泡沫（crema），因此口味強勁濃郁。濃縮咖啡的份量可以是單倍（single），雙倍（double）和三倍（triple），使用研磨咖啡粉比例大約為7、14、和21克。\n" +
                    "\n" +
                    "容量：25ml    沖泡時間：25秒    咖啡因：★★★☆☆"));
            models.add(new Model(R.drawable.dr38, "焦糖瑪奇朵", "配方:\n" +
                    "1/4杯(一份)濃縮咖啡 + 1/4杯(一份)奶泡\n" +
                    "若為焦糖瑪奇朵可在加上焦糖糖漿。\n" +
                    "\n" +
                    "口感: 這是一種擁有鮮奶香、法式香草甜香、焦糖濃香與咖啡醇香的咖啡。\n" +
                    "喝這種咖啡不可先攪拌，首先是覆蓋在上面、如同牛奶糖般甜甜的焦糖醬，其次是混合香草糖漿香甜的牛奶，最後一層是口味濃郁的義式咖啡。\n" + "容量：240ml    沖泡時間：60秒    咖啡因：★★★☆☆"));
            models.add(new Model(R.drawable.dr37, "摩卡咖啡", "配方:\n" +
                    "2/5濃縮咖啡\n" +
                    "2/5熱巧克力\n" +
                    "1/5蒸氣牛奶\n" +
                    "\n" +
                    "口感: 除了有巧克力的風味之外，摩卡咖啡中的濃縮咖啡含量比卡布奇諾還要高，味道也更為濃醇。" +
                    "有人會在摩卡咖啡裡添加一些酒類，如貝里詩奶酒、森布卡茴香酒（Sambuca）、咖啡酒等，讓咖啡又別有一番風味。\n" + "容量：240ml    沖泡時間：60秒    咖啡因：★★★☆☆"));
            models.add(new Model(R.drawable.dr36, "凱撒米朗琪", "材料\n" +
                    "1.蛋黃一個\n" +
                    "2.干邑(Cognac)一小杯(白蘭地的一種)\n" +
                    "3.糖1/2湯匙\n" +
                    "4.Espresso一小杯\n" +
                    "5.熱牛奶1/2大杯\n" +
                    "做法\n" +
                    "將1.2.3.放入杯中攪勻，加入熱咖啡，再注滿熱牛奶。\n"
            ));
            models.add(new Model(R.drawable.dr35, "巧克力冰咖啡", "材料\n" +
                    "1.冰塊7一8顆\n" +
                    "2.Espresso咖啡一杯\n" +
                    "3.義大利巧克力粉半包\n" +
                    "4.牛奶1OOcc\n" +
                    "5.糖漿(視個人需要而定)\n" +
                    "6.香草冰淇淋一球\n" +
                    "\n" +
                    "做法\n" +
                    "將上述材料全放入一新型超高速Blender裡，快速將冰塊打碎成泥狀，而且汁液呈濃稠狀。\n"));
            models.add(new Model(R.drawable.dr34, "瑞士巧克力咖啡", "材料\n" +
                    "1.含糖巧克力粉15公克或巧克力糖漿]盎司\n" +
                    "2.咖啡粉7公克\n" +
                    "3.水量12Occ\n" +
                    "\n" +
                    "做法\n" +
                    "1.先將1.放入咖啡杯內。\n" +
                    "2.把咖啡沖入杯內約八、九分滿，攪勻即成。\n"));
            models.add(new Model(R.drawable.dr33, "牙買加咖啡", "材料\n" +
                    "1.綜合咖啡一杯\n" +
                    "2.蘭姆酒1盎司\n" +
                    "3.白蘭地1盎司\n" +
                    "4.打發的鮮奶油\n" +
                    "5.荳蔻粉少許\n" +
                    "\n" +
                    "做法\n" +
                    "1.將熱咖啡盛裝後，淋入蘭姆酒1盎司，白蘭地1盎司，再擠上一層鮮奶油，並灑上少許荳蔻粉。\n"));
            models.add(new Model(R.drawable.dr32, "法式牛奶咖啡", "材料\n" +
                    "1.咖啡粉7公克\n" +
                    "2.水量4Occ\n" +
                    "3.熱牛奶12Occ\n" +
                    "\n" +
                    "做法\n" +
                    "1.將咖啡沖入杯內。\n" +
                    "2.把打熱的牛奶加入杯內。\n"));
            models.add(new Model(R.drawable.dr31, "跳舞咖啡", "材料\n" +
                    "1.熱牛奶12Occ\n" +
                    "2.糖槳1盎司\n" +
                    "3.咖啡粉7公克\n" +
                    "4.水量8Occ\n" +
                    "5.牛奶泡沫適量\n" +
                    "\n" +
                    "做法\n" +
                    "1.先把熱牛奶加入玻璃杯內。\n" +
                    "2.將糖漿加入杯內。\n" +
                    "3.把熱咖啡沿著湯匙背面流入杯內。\n" +
                    "4.上覆牛奶泡沫即成，喝先攪拌均勻。\n"));
            models.add(new Model(R.drawable.dr30, "揶香咖啡", "材料\n" +
                    "1.椰奶1盎司\n" +
                    "2.咖啡粉7公克\n" +
                    "3.水量120cc\n" +
                    "\n" +
                    "做法\n" +
                    "1.將咖啡沖入杯內。\n" +
                    "2.把椰奶也加入並攪勻。\n"));
            models.add(new Model(R.drawable.dr29, "康寶藍咖啡", "材料\n" +
                    "1.Espresso一杯\n" +
                    "2.打發的鮮奶油花一朵\n" +
                    "\n" +
                    "做法\n" +
                    "1.煮一杯espresso。\n" +
                    "2.擠上打發的鮮奶油花一朵。\n"));
            models.add(new Model(R.drawable.dr28, "雪花咖啡", "材料\n" +
                    "1.Espresso一杯\n" +
                    "2.打熱並濃稠綿細的牛奶適量\n" +
                    "\n" +
                    "做法\n" +
                    "1.先將Espresso咖啡倒入杯內。\n" +
                    "2.再將打得濃稠綿細的熱牛奶倒入杯內，或用湯匙一匙匙舀入杯內，使咖啡表 面形成花形、心形或圓形。\n"));
            models.add(new Model(R.drawable.dr25, "君度酒咖啡", "配方:\n" +
                    "（法國）深培的咖啡 100cc\n" +
                    "君度酒 20cc\n" +
                    "攪拌奶油 20cc\n" +
                    "杯中倒入咖啡、君度酒，然後，將攪拌奶油覆蓋在上面。\n" +
                    "\n" +
                    "君度酒是法國產的利口酒，屬白橙香酒的一種。在釀造這種酒的法國西部昂熱地區，習慣兌在咖啡裡一起。巴黎蒙帕納斯一帶的酒吧裡提供的主要是這種咖啡\n"));
            models.add(new Model(R.drawable.dr24, "光環咖啡 ", "配方:\n" +
                    "（法國、美國）略微深培的咖啡 100cc\n" +
                    "白蘭地 20cc\n" +
                    "方糖 1\n" +
                    "橙皮 少許\n" +
                    "\n" +
                    "將杯溫熱，然後，裡面放進方糖和橙皮，倒入燙過的白蘭地酒，點著火。當燃燒出淡藍色火苗時，將咖啡倒進去。\n" +
                    "\n" +
                    "這是一種將豪華咖啡簡單化的引用方法。適合於餐後少量引用的場合。\n"));
            models.add(new Model(R.drawable.dr23, "奶泡咖啡", "配方:\n" +
                    "(法國)深培的咖啡 150cc\n" +
                    "泡沫牛奶 80cc\n" +
                    "\n" +
                    "杯中倒入咖啡，注入攪起泡沫的牛奶\n" +
                    "\n" +
                    "典型的法國式引用方法。近年來，牛奶咖啡已不多見，取而代之的是奶油咖啡。使用奶油攪汁器將牛奶攪起泡沫起泡的牛奶易於引用，而且，其狀態又似奶油狀。如果點牛奶咖啡，服務員提供的便是這種咖啡。\n"));
            models.add(new Model(R.drawable.dr_22, "希臘羅馬式咖啡 ", "配方:\n" +
                    "（希臘、義大利）深培的咖啡細粉 8g\n" +
                    "水 100cc\n" +
                    "橙皮 少許\n" +
                    "檸檬皮 少許\n" +
                    "加配的橙皮果醬\n" +
                    "使用專用咖啡壺\n" +
                    "將盛有咖啡粉、水、橙皮、檸檬皮的專用咖啡壺放在火上煮。剛煮沸時立即將咖啡壺端離火位，放置約1分鐘，然後，倒在杯裡，澆上橙皮果醬。\n" +
                    "\n" +
                    "這是羅馬風味的希臘咖啡。希臘或土耳其人喝咖啡時通常要配上水果。而位於地中海沿岸的義大利也由此相同習慣。\n"));
            models.add(new Model(R.drawable.dr_21, "金萬利香橙白蘭地咖啡", "配方:\n" +
                    "(法國、英國)深培的咖啡 100cc\n" +
                    "金萬利香橙白蘭地 20cc\n" +
                    "攪拌奶油 20cc\n" +
                    "\n" +
                    "杯中放入金萬利香橙白蘭地，注入咖啡，然後，將攪拌奶油覆蓋在上面。 " +
                    "金萬利香橙白蘭地屬橙香型利口酒，在法國和英國一般兌在咖啡中引用。特別是用餐時，多作為餐後酒引用。\n"));
            models.add(new Model(R.drawable.dr_20, "櫻桃酒咖啡", "配方:\n" +
                    "(德國、奧地利)略微深培的咖啡 75cc\n" +
                    "櫻桃酒 20cc\n" +
                    "杯中倒入咖啡，小玻璃杯中倒入櫻桃酒。\n" +
                    "\n" +
                    "「Kirsch」是德語中櫻桃的意思。其正式說法應該是「Kirschwasser」,即：櫻桃白蘭地。邊喝咖啡，邊飲櫻桃酒，交替品嘗，別有風味。該酒雖然名叫櫻桃白蘭地，但實際隸屬利口酒類。\n"));
            models.add(new Model(R.drawable.dr_19, "罐咖啡", "配方:\n" +
                    "(美國)深培的咖啡 200cc\n" +
                    "桂皮棒 1根\n" +
                    "\n" +
                    "杯中倒入咖啡，插上桂皮棒。\n" +
                    "\n" +
                    "罐咖啡指在空罐中倒入咖啡的意思。移居美國的義大利人常用空罐喝咖啡，當然，這也是生活水準低下的標誌。後來，義大利移民遷移到美國西部後，這種引用方式便被帶到了西部邊陲，由此，誕生了帶柄的大杯子" +
                    "，可見這與公共酒吧啤酒杯的誕生過程不同。美國人至盡仍保留著只用杯子，不用托碟引用咖啡的方式。\n"));
            models.add(new Model(R.drawable.dr_18, "蘋果白蘭地咖啡", "配方:\n" +
                    "（法國）深培的咖啡 75cc\n" +
                    "加配的蘋果白蘭地 20cc\n" +
                    "杯中放咖啡，玻璃杯中放蘋果白蘭地。\n" +
                    "\n" +
                    "蘋果白蘭地實際是用蘋果製作的白蘭地。如果說德國人喜歡將咖啡與櫻桃白蘭地兌在一起引用，那麼，法國人（特別是男士）則更喜歡將蘋果白蘭地與咖啡交替引用。在英格麗•褒曼和查理•波瓦耶聯合主演的雷馬克名作《凱旋門》中，有一個喝咖啡的場面，兩人戲中引用的正是蘋果白蘭地咖啡。" +
                    "在巴黎的酒吧裡，經常可以看到結束了一天的工作的人們引用蘋果白蘭地咖啡的場景。\n"));
            models.add(new Model(R.drawable.dr_17, "小豆蔻咖啡●北歐風味", "配方:\n" +
                    "(北歐各國)略微深培的咖啡 120cc\n" +
                    "幹邑或其他白蘭地酒 15cc\n" +
                    "甜橙酒 10cc\n" +
                    "小豆蔻 5粒\n" +
                    "方糖 2塊\n" +
                    "先將杯、幹邑白蘭地、甜橙酒燙好。杯中倒入幹邑酒、甜橙酒，放進小豆蔻、方糖後點著或（房間光線要暗）。酒精燃燒完畢在注入咖啡。\n" +
                    "\n" +
                    "特點為小豆蔻味道醇厚。正規做法是用大平底鍋同時做出4、5人的量。該咖啡又稱「北歐的賓治咖啡」。\n"));
            models.add(new Model(R.drawable.dr_16, "可羅酒咖啡", "配方:\n" +
                    "（美國、墨西哥）深培的咖啡 150\n" +
                    "咖啡甜酒（墨西哥的咖啡利口酒） 20cc\n" +
                    "白砂糖 10g\n" +
                    "攪拌奶油 20cc\n" +
                    "\n" +
                    "杯子裡放進白砂糖，倒入咖啡酒，注入咖啡，輕輕地將攪拌奶油覆蓋在上面（不要在咖啡中攪動）。\n" +
                    "\n" +
                    "在墨西哥一般是注入冷咖啡，而在歐美則是注入熱咖啡。\n"));
            models.add(new Model(R.drawable.dr_15, "里約熱內盧咖啡", "配方:\n" +
                    "(巴西)深培的咖啡 100cc\n" +
                    "砂糖 15g\n" +
                    "朗姆酒 15cc\n" +
                    "橙（切開） 1/4個\n" +
                    "攪拌奶油 20cc\n" +
                    "橙粉 少許\n" +
                    "\n" +
                    "杯中放進砂糖、朗姆酒、橙瓣，注入咖啡。上面用攪拌奶油覆蓋，在撒上橙粉（也可用刮下的橙皮屑代替）\n" +
                    "\n" +
                    "里約熱內盧咖啡的特點在於橙味與奶油味交融，帶給人一種美味的享受。\n"));
            models.add(new Model(R.drawable.dr_14, "義大利甜酒咖啡", "配方:\n" +
                    "(義大利、美國)深培的咖啡 100cc\n" +
                    "義大利甜酒 20cc\n" +
                    "攪拌奶油 20cc\n" +
                    "\n" +
                    "杯中倒入義大利甜酒，注入咖啡，上面用攪拌奶油浮蓋。\n" +
                    "\n" +
                    "義大利甜酒是義大利有代表性的甜味利口酒，在義大利北部的米蘭地區很普及。用義大利甜酒與咖啡勾兌在一起的引用可以說始於19世紀後半期，而將這種方法推廣成世界性飲料的，" +
                    "則要歸功於移居美國的義大利移民。20世紀初，義大利甜酒咖啡在紐約一下子成了熱門貨。\n"));
            models.add(new Model(R.drawable.dr_13, "可哥咖啡", "配方:\n" +
                    "(東歐各國)深培的咖啡 150cc\n" +
                    "可哥甜酒 15cc\n" +
                    "攪拌奶油 20cc\n" +
                    "\n" +
                    "杯中倒入咖啡、可哥甜酒，然後，將攪拌奶油浮蓋在上面。\n" +
                    "\n" +
                    "可哥甜酒是與咖啡最相配的甜酒，而且，咖啡加可哥也是歐洲最普遍的引用方法。這種咖啡既可以熱飲也可以冷飲，因此，尤其受匈牙利、波蘭等東歐人的青睞。\n"));
            models.add(new Model(R.drawable.dr2, "愛爾蘭甜酒咖啡", "配方:\n" +
                    "（愛爾蘭）略微深培的咖啡 150cc\n" +
                    "愛爾蘭甜酒 20cc\n" +
                    "白砂糖 10g\n" +
                    "攪拌奶油 20cc\n" +
                    "\n" +
                    "杯子燙好後，放入白砂糖、愛爾蘭甜酒，倒入咖啡，再將攪拌奶油輕輕浮蓋在上面，注意不要攪拌。\n" +
                    "愛爾蘭甜酒是由愛爾蘭產的威士卡、蜂蜜、香草配製而成的咖啡酒。咖啡、奶油、甜酒融合在一起，其味道之絕妙，令人傾倒。\n"));
            models.add(new Model(R.drawable.dr3, "馭手咖啡", "配方:\n" +
                    "(奧地利)深培的咖啡 120cc\n" +
                    "攪拌奶油 20cc\n" +
                    "\n" +
                    "※根據需要有可撒些綿白糖\n" +
                    "在杯子裡倒入咖啡，將攪拌奶油浮蓋在上面。維也納式的上桌方法是使用託盤，上面放個杯墊，咖啡杯放在杯墊上。同時，託盤上再放一個糖水杯 ，杯上架一把茶匙。\n"));
            models.add(new Model(R.drawable.dr4, "希神咖啡", "配方:\n" +
                    " (美國)略微深培的咖啡 150cc\n" +
                    "義大利甜酒 10cc\n" +
                    "白蘭地 10cc\n" +
                    "薑粉 少許\n" +
                    "白蘭地（燃燒用） 20cc\n" +
                    "方糖 一塊\n" +
                    "\n" +
                    "杯裡到入咖啡、義大利甜酒、白蘭地，撒上薑粉。白蘭地和茶匙。茶匙架在杯上，上面放一塊方糖，到入燙熱的白蘭地，然後點火。火熄滅後，用上面的茶匙輕輕攪拌即可。 \n"));
            models.add(new Model(R.drawable.dr5, "瓦斯特克咖啡", "配方:\n" +
                    "(墨西哥)深培的咖啡 75cc\n" +
                    "泡沫牛奶 75cc\n" +
                    "石榴汁 10cc\n" +
                    "綠薄荷酒 20cc\n" +
                    "\n" +
                    "杯中倒入石榴汁、綠薄荷酒，放入攪起的牛奶泡沫，用茶匙貼著杯子邊緣，慢慢地將咖啡澆在泡沫上面，使牛奶與咖啡形成層次。\n"));

        }
        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color10),
                getResources().getColor(R.color.color11),
                getResources().getColor(R.color.color12)
        };

        colors = colors_temp;

        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }/*else {
                    if(position>0)
                        viewPager.setBackgroundColor(colors[position - 1]);
                }*/
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
