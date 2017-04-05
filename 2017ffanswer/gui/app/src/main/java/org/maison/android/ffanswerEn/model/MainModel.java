package org.maison.android.ffanswerEn.model;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by Danxun.Jiao on 03/01/2017.
 */

public class MainModel {
    private String TAG="MainModel";
    private int[] articles = {1489, 1491, 1493, 1494, 1495, 1496, 1497, 1498, 1499, 1502,
            1503, 1504, 1509, 1510, 1511, 1512, 1513, 1514, 1515, 1516, 1518, 1522, 1523, 1524,
            1525, 1526, 1527, 1528, 1529, 1530, 1531, 1532, 1533, 1536, 1537, 1538, 1540, 1541,
            1542, 1543, 1547, 1552, 1554, 1555, 1556, 1557, 1558, 1559, 1560, 1561, 1567, 1568,
            1569, 1570, 1571, 1572, 1576, 1579, 1580, 1581, 1583, 1584, 1585, 1586, 1587, 1588,
            1589, 1590, 1591, 1592, 1593, 1594, 1595, 1597, 1598, 1599, 1600, 1601, 1602, 1603,
            1604, 1605, 1606, 1607, 1608, 1609, 1610, 1611, 1612};

    private String[] titles = { "Mondial : Les Bleus toujours dans la course !",
            "Nouvelle attaque au Kenya",
            "France : les priorités du premier ministre",
            "Do you speak djembé ?",
            "France : un procès exemplaire",
            "James Garner joue sa dernière carte",
            "Images de guerre à Gaza",
            "Tensions ethniques en Birmanie",
            "Discours d'Obama aux YALI",
            "Nouvelles représailles d’Israël",
            "Aux origines de l’homme",
            "Soupçons de corruption au Brésil",
            "Le « yes » qui inquiète Londres",
            "Ukraine : une trêve fragile",
            "L'économie mondiale dans le rouge",
            "Un nouveau président en Afghanistan",
            "Accord entre l’Afrique du Sud et la Russie",
            "L'urgence Ebola",
            "Hongkong dans la rue",
            "Le retour de La Manif pour tous",
            "Le prix Nobel de physique dans la lumière",
            "La reconstruction de Gaza",
            "Un prix Nobel dans l'Hexagone",
            "Exercice flash : Le Nobel pour Patrick Modiano",
            "Nouveau bilan de l'épidémie d'Ebola",
            "Syrie : quelle aide pour Kobané ?",
            "Élections présidentielles au Brésil",
            "Russie, organisation de la Coupe du monde de football",
            "Le journalisme d'investigation en danger",
            "Burkina : une transition en marche",
            "11 novembre : à la mémoire des soldats",
            "L’Ukraine s’invite au G20",
            "Accord entre la Chine et l'Australie",
            "Tunisie : des élections historiques",
            "États-Unis : Ferguson s'embrase",
            "La Francophonie change de tête",
            "Le retour !",
            "Hagupit traverse les Philippines",
            "L’appel du PAM",
            "Turquie: le mouvement Gülen",
            "Belgique : une&nbsp;grève «&nbsp;historique&nbsp;»",
            "Le trafic des migrants",
            "La Grèce et l’euro",
            "France : un hommage national",
            "L’Allemagne se mobilise",
            "François Hollande applaudi en Corrèze",
            "Richesse / pauvreté : le grand écart",
            "Victoire de Syriza en Grèce",
            "Rien ne va plus pour Barbie !",
            "Espagne : la marche pour le changement",
            "Bob Dylan : <i> Shadows in the night</i>",
            "Disparition d'André Brink",
            "Le scandale HSBC",
            "Un nouvel acte de terrorisme en Europe",
            "Louis Jourdan : une star française en Amérique",
            "Agriculture et changement climatique",
            "Retour sur la soirée des Oscars",
            "Moscou : l’assassinat de Boris Nemtsov",
            "Une nouvelle «&nbsp;prime d’activité&nbsp;» en France",
            "Palmarès du Fespaco",
            "Le sport français en deuil",
            "Pam détruit le Vanuatu",
            "L'Égypte veut changer de capitale",
            "Avancées de l’enquête sur l’attentat du Bardo",
            "Une situation explosive au Yémen",
            "L'après crash aérien dans les Alpes",
            "Que devient la loi martiale en Thaïlande ?",
            "Conflit en Ukraine : un an après",
            "Violences policières aux États-Unis",
            "Hillary Clinton, candidate à la présidence",
            "Disparition de Günter Grass",
            "Départ de <i>L’Hermione</i>",
            "La situation économique dans les pays arabes",
            "Séisme au Népal",
            "Scandale en Allemagne",
            "Sauvetages en mer Méditerranée",
            "Du nouveau dans le dépistage du VIH",
            "Mémorial ACTe",
            "Disparition de B.B. King",
            "Crise migratoire en Asie du Sud-Est",
            "Festival de Cannes 2015",
            "Des Résistants au Panthéon",

            "Irak : proclamation d’un « califat islamique »",

            "Sepp Blatter quitte la FIFA",
            "An American in Paris</i> triomphe à New York !",
            "Albert Woodfox libéré ?",
            "Des nouvelles de Philae !",
            "Portrait de Jean Vautrin",
            "Manifestations en Grande-Bretagne"};


    private String title1;
    private String title2;
    private String title3;
    private String title4;
    private String title5;
    private String title6;

    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
    private String url6;

    @Override
    public String toString() {
        return "MainModel{" +
                "TAG='" + TAG + '\'' +
                ", title1='" + title1 + '\'' +
                ", title2='" + title2 + '\'' +
                ", title3='" + title3 + '\'' +
                ", title4='" + title4 + '\'' +
                ", title5='" + title5 + '\'' +
                ", title6='" + title6 + '\'' +
                ", url1='" + url1 + '\'' +
                ", url2='" + url2 + '\'' +
                ", url3='" + url3 + '\'' +
                ", url4='" + url4 + '\'' +
                ", url5='" + url5 + '\'' +
                ", url6='" + url6 + '\'' +
                ", no1=" + no1 +
                ", no2=" + no2 +
                ", no3=" + no3 +
                ", no4=" + no4 +
                ", no5=" + no5 +
                ", no6=" + no6 +
                '}';
    }

    public MainModel (int mCurrentPage){
        Log.d(TAG,"MainModel construct,mCurrentPage="+mCurrentPage);
        this.title1=titles[mCurrentPage*6+0];
        this.title2=titles[mCurrentPage*6+1];
        this.title3=titles[mCurrentPage*6+2];
        this.title4=titles[mCurrentPage*6+3];
        this.title5=titles[mCurrentPage*6+4];
        this.title6=titles[mCurrentPage*6+5];

        this.url1="assets://faitdujour/"+articles[mCurrentPage*6+0]+"photo.jpg";
        this.url2="assets://faitdujour/"+articles[mCurrentPage*6+1]+"photo.jpg";
        this.url3="assets://faitdujour/"+articles[mCurrentPage*6+2]+"photo.jpg";
        this.url4="assets://faitdujour/"+articles[mCurrentPage*6+3]+"photo.jpg";
        this.url5="assets://faitdujour/"+articles[mCurrentPage*6+4]+"photo.jpg";
        this.url6="assets://faitdujour/"+articles[mCurrentPage*6+5]+"photo.jpg";

        this.no1=articles[mCurrentPage*6+0];
        this.no2=articles[mCurrentPage*6+1];
        this.no3=articles[mCurrentPage*6+2];
        this.no4=articles[mCurrentPage*6+3];
        this.no5=articles[mCurrentPage*6+4];
        this.no6=articles[mCurrentPage*6+5];



    }




    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    public String getTitle5() {
        return title5;
    }

    public void setTitle5(String title5) {
        this.title5 = title5;
    }

    public String getTitle6() {
        return title6;
    }

    public void setTitle6(String title6) {
        this.title6 = title6;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getUrl6() {
        return url6;
    }

    public void setUrl6(String url6) {
        this.url6 = url6;
    }


    private int no1;
    private int no2;
    private int no3;
    private int no4;
    private int no5;
    private int no6;

    public int getNo1() {
        return no1;
    }

    public void setNo1(int no1) {
        this.no1 = no1;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getNo3() {
        return no3;
    }

    public void setNo3(int no3) {
        this.no3 = no3;
    }

    public int getNo4() {
        return no4;
    }

    public void setNo4(int no4) {
        this.no4 = no4;
    }

    public int getNo5() {
        return no5;
    }

    public void setNo5(int no5) {
        this.no5 = no5;
    }

    public int getNo6() {
        return no6;
    }

    public void setNo6(int no6) {
        this.no6 = no6;
    }
}
