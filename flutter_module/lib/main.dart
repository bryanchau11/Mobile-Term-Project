import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:url_launcher/url_launcher.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'BORDEAUXIEN RESTAURANT',
      theme: ThemeData(
        backgroundColor: Color.fromARGB(255,137,171,227),
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or press Run > Flutter Hot Reload in a Flutter IDE). Notice that the
        // counter didn't reset back to zero; the application is not restarted.
        primarySwatch: Colors.green,
      ),
      home: MyContactPage(title: 'Bordeauxien Restaurant'),
      //contact: MyContactPage(title: 'Contact')
    routes: {
        '/about': (context) => MyAboutPage(title: 'About'),
        '/contact': (context) => MyContactPage(title: 'Contact'),
      },
    );
  }
}


class MyContactPage extends StatefulWidget {
  MyContactPage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyContactPageState createState() => _MyContactPageState();
}

class _MyContactPageState extends State<MyContactPage> {
  //  int _counter = 0;


  //void _incrementCounter() {
  // setState(() {
  // This call to setState tells the Flutter framework that something has
  // changed in this State, which causes it to rerun the build method below
  // so that the display can reflect the updated values. If we changed
  // _counter without calling setState(), then the build method would not be
  // called again, and so nothing would appear to happen.
  //     _counter++;
  //   });
  //  }

  @override
  //Widget build(BuildContext context) {
  Widget build(BuildContext context) {
    final appName = 'Custom Themes';
    final ThemeData theme = Theme.of(context);
    final TextStyle textStyle = theme.textTheme.bodyText2;
    // https://cdn3.iconfinder.com/data/icons/business-vol-26/100/Artboard_2-512.png
    final member1 = Column(
      children: [
        const ListTile(
          leading: ClipOval(
            child: Material(
              color: Colors.white, // button color
              child: InkWell(
                // splashColor: Colors.red, // inkwell color
                child: SizedBox(width: 56, height: 56, child: Icon(
                  Icons.person,
                  color: Colors.pink,
                  size: 30.0,
                  semanticLabel: 'Text to announce in accessibility modes',
                )),
                // onTap: () {},
              ),
            ),
          ),
          title: Text('Name'),
          subtitle: Text('Bryan Chau'),
        ),
      ],
    );

    final member2 = Column(
      children: [
        const ListTile(
          leading: ClipOval(
            child: Material(
              color: Colors.white, // button color
              child: InkWell(
                // splashColor: Colors.red, // inkwell color
                child: SizedBox(width: 56, height: 56, child: Icon(
                  Icons.phone,
                  color: Colors.pink,
                  size: 30.0,
                  semanticLabel: 'Text to announce in accessibility modes',
                )),
                // onTap: () {},
              ),
            ),
          ),
          title: Text('Call'),
          subtitle: Text('+1 232-232-7728'),
        ),
      ],
    );

    final member3 = Column(
      children: [
        const ListTile(
          leading: ClipOval(
            child: Material(
              color: Colors.white, // button color
              child: InkWell(
                // splashColor: Colors.red, // inkwell color
                  child: SizedBox(width: 56, height: 56, child: Icon(
                    Icons.mail,
                    color: Colors.pink,
                    size: 30.0,
                    semanticLabel: 'Text to announce in accessibility modes',
                  )),
                // onTap: () {},
              ),
            ),
          ),
          title: Text('Email'),
          subtitle: Text('test@gmail.com'),
        ),
      ],
    );

    final member4 = Column(
      children: [
        const ListTile(
          leading: ClipOval(
            child: Material(
              color: Colors.white, // button color
              child: InkWell(
                // splashColor: Colors.red, // inkwell color
                child: SizedBox(width: 56, height: 56, child: Icon(
                  Icons.location_pin,
                  color: Colors.pink,
                  size: 30.0,
                  semanticLabel: 'Text to announce in accessibility modes',
                )),
              ),
            ),
          ),
          title: Text('Location'),
          subtitle: Text('123 Bordeaux, Paris, France'),
          // onTap: () {
          //   launch("tel://+16896901523");
          // },
        ),
      ],
    );
    return MaterialApp(
      title: 'ONCE UPON A WINERY',
      theme: ThemeData(fontFamily: 'Playball' ),
      home: Scaffold(
          appBar: AppBar(
            title: Text('Contact'),
          ),
          body: Column(
            children: <Widget>[
              SizedBox(height: 12),
              member1,
              member2,
              member3,
              member4,
            ],
          )
      ),
    );
  }
}






class MyAboutPage extends StatefulWidget {
  MyAboutPage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyAboutPageState createState() => _MyAboutPageState();
}

class _MyAboutPageState extends State<MyAboutPage> {
  final items = ['Bryan Chau','Sunwoo Chung','Lakshmi Maanasa','Hari Priya Vuppu'];

 //  int _counter = 0;


  //void _incrementCounter() {
   // setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
 //     _counter++;
 //   });
 //  }

  @override
  //Widget build(BuildContext context) {
    Widget build(BuildContext context) {
      final appName = 'Custom Themes';
      final ThemeData theme = Theme.of(context);
      final TextStyle textStyle = theme.textTheme.bodyText2;
      backgroundColor: Color.fromARGB(255,233,30,99);
      // https://cdn3.iconfinder.com/data/icons/business-vol-26/100/Artboard_2-512.png
      final member1 = Column(
        children: [
          const ListTile(
            leading: ClipOval(
              child: Material(
                color: Colors.white, // button color
                child: InkWell(
                  // splashColor: Colors.red, // inkwell color
                  child: SizedBox(width: 56, height: 56, child: Image(
                    image: NetworkImage('https://cdn1.vectorstock.com/i/1000x1000/48/60/avatar-faceless-male-profile-vector-23704860.jpg'),
                  )),
                  // onTap: () {},
                ),
              ),
            ),
            title: Text('Bryan Chau'),
            subtitle: Text("Bryan is the Founder of the Bordeauxien. He has a good eye for what makes an excellent wine, which makes our company the market leader in winery industry"),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: <Widget>[
              TextButton(
                child: const Text('CONTACT'),
                onPressed: () {
                    launch("tel://+16896901523");
                    },
              ),
              const SizedBox(width: 8),
              TextButton(
                child: const Text('VISIT\t WEBSITE'),
                onPressed: () {
                  launch('https://github.com/bryanchau11');
                },
              ),
              const SizedBox(width: 8),
            ],
          )
        ],
      );

      final member2 = Column(
        children: [
          const ListTile(
            leading: ClipOval(
              child: Material(
                color: Colors.white, // button color
                child: InkWell(
                  splashColor: Colors.grey,
                  child: SizedBox(width: 56, height: 56, child: Image(
                    image: NetworkImage('https://cdn1.vectorstock.com/i/1000x1000/48/60/avatar-faceless-male-profile-vector-23704860.jpg'),
                  )),
                  // onTap: () {},
                ),
              ),
            ),
            title: Text('Sunwoo Chung'),
            subtitle: Text("\nSunwoo is the CEO of Bordeauxien. He has 7+ years of experience in this industry. He has previously worked for various reputed MNCs"),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: <Widget>[
              TextButton(
                child: const Text('CONTACT'),
                onPressed: () {
                  launch("tel://+15224558222");
                  },
              ),
              const SizedBox(width: 8),
              TextButton(
                child: const Text('VISIT\t WEBSITE'),
                onPressed: () {
                launch('https://github.com/sunwoo16');
                },
       ),
              const SizedBox(width: 8),
            ],
          )
        ],
      );

      final member3 = Column(
        children: [
          const ListTile(
            leading: ClipOval(
              child: Material(
                color: Colors.white, // button color
                child: InkWell(
                  // splashColor: Colors.red, // inkwell color
                  child: SizedBox(width: 56, height: 56, child: Image(
                    image: NetworkImage('https://cdn2.vectorstock.com/i/1000x1000/54/41/young-and-elegant-woman-avatar-profile-vector-9685441.jpg'),
                  )),
                  // onTap: () {},
                ),
              ),
            ),
            title: Text('Lakshmi Maanasa'),
            subtitle: Text("Lakshmi Maanasa is the technical head of Bordeauxien. She is a freelancer who has worked for various reputed companies in the past. She has 5+ years of experience."),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: <Widget>[
              TextButton(
                child: const Text('CONTACT'),
                onPressed: () {
                  launch("tel://+16969575281");
                },
              ),
              const SizedBox(width: 8),
              TextButton(
                child: const Text('VISIT\t WEBSITE'),
                onPressed: () {
                  launch('https://github.com/lmaanasa');
                },
              ),
              const SizedBox(width: 8),
            ],
          )
        ],
      );

      final member4 = Column(
        children: [
          const ListTile(
            leading: ClipOval(
              child: Material(
                color: Colors.white, // button color
                child: InkWell(
                  // splashColor: Colors.red, // inkwell color
                  child: SizedBox(width: 56, height: 56, child: Image(
                    image: NetworkImage('https://cdn2.vectorstock.com/i/1000x1000/54/41/young-and-elegant-woman-avatar-profile-vector-9685441.jpg'),
                  )),
                  // onTap: () {},
                ),
              ),
            ),
            title: Text('HariPriya Vuppu'),
            subtitle: Text("Hari Priya is the Marketing Head of Bordeauxien. She has 7+ years of experience in the winery industry. She has worked with various reputed MNCs in the past."),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: <Widget>[
              TextButton(
               child: const Text('CONTACT'),
                       onPressed: () {
                       launch("tel://+16786703131");
                       },
           ),
              const SizedBox(width: 8),
              TextButton(
                child: const Text('VISIT\t WEBSITE'),
                        onPressed: () {
                        launch('https://github.com/hvuppu');
                        },
              ),
              const SizedBox(width: 8),
            ],
          )
        ],
      );
      final aboutPara = "Since planting our first vines in 1962, the Plantier family name has become synonymous with the highest quality French varietal wines from the Bordeaux region. For the team at Plantier Family Winery, every harvest is the realization of the French dream\n"
          +  "Today, we believe in the importance of family more than ever – the one you’re born into and the one you choose. There is always a seat at our table and all are welcome to share in our daily celebration of family, Plantier, and the bounty "
          +  "of our home in Bordeaux.\n"
          + "We aim to support our local area. We also provide services that could help those who are always in rush due to their busy work from our city. "
          + "Bordeauxien also do our best to source locally made foods and accessories to sell at our tasting rooms as well!\n"
          + "\n"
          + "See you soon!";
      return MaterialApp(
        title: 'Text Styling in Flutter',
        theme: ThemeData(fontFamily: 'Playball'),
        home: Scaffold(
          backgroundColor: Color.fromARGB(255,252,246,245),
          appBar: AppBar(
            title: Text('About Us'),
          ),
          body: ListView(
            children: <Widget>[
              Column(
                children: <Widget>[
                  SizedBox(height: 24),
                  Padding(
                      padding: EdgeInsets.fromLTRB(12, 0, 12, 0),
                      child: Text( aboutPara,
                        textAlign: TextAlign.left,
                        style: TextStyle(fontWeight: FontWeight.normal, color: Color.fromARGB(255,233,30,99), fontSize: 30, fontFamily: 'Playball'),
                      )),
                  SizedBox(height: 12),
                  member1,
                  member2,
                  member3,
                  member4
                ],
              )
            ],
          )
        ),
      );
    }
  }

  // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.

  //}
//}


