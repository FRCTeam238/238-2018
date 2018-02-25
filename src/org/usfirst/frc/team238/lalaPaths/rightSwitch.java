package org.usfirst.frc.team238.lalaPaths;

import java.util.ArrayList;

public class rightSwitch{
	public static Object[][] objects = new Object[][]{
		{0.01 , 0.04621206510400255 , 0.03378793489599745 , 0.01792296587844172},
		{0.02 , 0.13863619531200766 , 0.10136380468799233 , 0.01792296587844172},
		{0.03 , 0.2772723906240153 , 0.20272760937598466 , 0.01792296587844172},
		{0.04 , 0.46212065104002553 , 0.3378793489599745 , 0.01792296587844172},
		{0.05 , 0.6931809765600384 , 0.5068190234399618 , 0.01792296587844172},
		{0.06 , 0.9704533671840537 , 0.7095466328159464 , 0.01792296587844172},
		{0.07 , 1.2939378229120717 , 0.9460621770879286 , 0.01792296587844172},
		{0.08 , 1.6636343437440921 , 1.2163656562559082 , 0.01792296587844172},
		{0.09 , 2.079542929680115 , 1.5204570703198854 , 0.03585931234993219},
		{0.1 , 2.542106613312036 , 1.8578933866879637 , 0.05380904656384945},
		{0.11 , 3.05106019587201 , 2.2289398041279895 , 0.05380904656384945},
		{0.12 , 3.6057984133032845 , 2.634201586696715 , 0.0717721756602207},
		{0.13 , 4.207499545350093 , 3.072500454649909 , 0.08974870676970959},
		{0.14 , 4.856080676013274 , 3.5439193239867293 , 0.12574200350305018},
		{0.15 , 5.551264452916619 , 4.048735547083377 , 0.14375878334085165},
		{0.16 , 6.2925362294821845 , 4.587463770517819 , 0.16178899361930135},
		{0.17 , 7.080967594730419 , 5.159032405269585 , 0.19788973382004338},
		{0.18 , 7.9168064675334255 , 5.763193532466562 , 0.23404428065186178},
		{0.19 , 8.799551989513617 , 6.400448010486392 , 0.2702526905043626},
		{0.2 , 9.730115199870376 , 7.069884800129604 , 0.3246664214085798},
		{0.21 , 10.707864378174945 , 7.772135621825067 , 0.3610097344726792},
		{0.22 , 11.732864878231737 , 8.507135121768282 , 0.41562608232858833},
		{0.23 , 12.806322893388636 , 9.273677106611363 , 0.4703642508976977},
		{0.24 , 13.927370017842462 , 10.072629982157562 , 0.5252244270555076},
		{0.25 , 15.097440181442884 , 10.902559818557155 , 0.5985614395665729},
		{0.26 , 16.316956874553536 , 11.763043125446462 , 0.6721161235638797},
		{0.27 , 17.58478819376367 , 12.655211806236329 , 0.7458889147455582},
		{0.28 , 18.87948263370473 , 13.560517366295267 , 0.838412276060828},
		{0.29 , 20.178185650884515 , 14.461814349115528 , 0.9312779448567343},
		{0.3 , 21.4793289331777 , 15.360671066822324 , 1.0244867527367143},
		{0.31 , 22.782932410324097 , 16.25706758967586 , 1.1180395238056402},
		{0.32 , 24.091243822836283 , 17.148756177163747 , 1.2307580294743474},
		{0.33 , 25.404682727979893 , 18.03531727201994 , 1.3439744131807259},
		{0.34 , 26.72368180291139 , 18.91631819708863 , 1.4766912955316367},
		{0.35000000000000003 , 28.048687664537375 , 19.791312335462724 , 1.6100898817190021},
		{0.36 , 29.377377455831056 , 20.66262254416915 , 1.7441722989886934},
		{0.37 , 30.709790573671114 , 21.53020942632919 , 1.8789406406218707},
		{0.38 , 32.04904185037633 , 22.390958149623483 , 2.0338041485708636},
		{0.39 , 33.395620831512545 , 23.244379168487352 , 2.189569259452022},
		{0.4 , 34.750034019734294 , 24.089965980265653 , 2.3658863781448836},
		{0.41000000000000003 , 36.109264349936794 , 24.930735650063344 , 2.5235771112295238},
		{0.42 , 37.477071223991985 , 25.762928776007683 , 2.7219713860550185},
		{0.43 , 38.8540073045354 , 26.58599269546445 , 2.9017471470797487},
		{0.44 , 40.23660137153931 , 27.403398628461176 , 3.1028593022640707},
		{0.45 , 41.62913739592553 , 28.210862604074876 , 3.3054092284201593},
		{0.46 , 43.03221269623062 , 29.00778730376925 , 3.529880485900952},
		{0.47000000000000003 , 44.446448410810795 , 29.793551589188713 , 3.7561033390395013},
		{0.48 , 45.87248394625397 , 30.567516053745912 , 4.0048963947345975},
		{0.49 , 47.31098447866999 , 31.329015521330163 , 4.2557879785158885},
		{0.5 , 48.75748127481818 , 32.08251872518196 , 4.508784718089008},
		{0.51 , 50.217426590127374 , 32.822573409872426 , 4.785247240854085},
		{0.52 , 51.69153576157125 , 33.54846423842917 , 5.064194737110337},
		{0.53 , 53.174770364144635 , 34.265229635855526 , 5.345633620806904},
		{0.54 , 54.673216660779715 , 34.96678333922125 , 5.651514348758239},
		{0.55 , 56.1938316438782 , 35.646168356121535 , 5.982464187444101},
		{0.56 , 57.731638058367885 , 36.30836194163166 , 6.316751437191061},
		{0.5700000000000001 , 59.28077222686298 , 36.959227773137464 , 6.654380611434957},
		{0.58 , 60.84822681713511 , 37.5917731828655 , 7.0182052128129975},
		{0.59 , 62.434814553184815 , 38.20518544681509 , 7.3858369833787005},
		{0.6 , 64.04132795334502 , 38.7986720466556 , 7.780616402044241},
		{0.61 , 65.6685842995592 , 39.37141570044125 , 8.17968914275943},
		{0.62 , 67.3173614929565 , 39.92263850704343 , 8.606908675494408},
		{0.63 , 68.99654731660753 , 40.4434526833929 , 9.06306272059328},
		{0.64 , 70.69930426950366 , 40.940695730496806 , 9.524538437217911},
		{0.65 , 72.41773977240531 , 41.42226022759496 , 9.99131115940554},
		{0.66 , 74.16061224993092 , 41.87938775006936 , 10.488339984904371},
		{0.67 , 75.93763097657536 , 42.302369023425975 , 11.016454349672674},
		{0.68 , 77.74074256368826 , 42.699257436312216 , 11.55089773755234},
		{0.6900000000000001 , 79.5703264766083 , 43.06967352339163 , 12.117505562267722},
		{0.7000000000000001 , 81.43647785331304 , 43.403522146687074 , 12.717119386324146},
		{0.71 , 83.2775552105906 , 43.68244478940826 , 13.32403114987552},
		{0.72 , 85.09255219710748 , 43.90744780289316 , 13.964969534697795},
		{0.73 , 86.88034863654313 , 44.079651363459554 , 14.613545251528345},
		{0.74 , 88.63940166752589 , 44.20059833247837 , 15.29706634331194},
		{0.75 , 90.37850963539739 , 44.2614903646038 , 16.01625673968069},
		{0.76 , 92.08523037671907 , 44.274769623282886 , 16.743655527789745},
		{0.77 , 93.75689637107851 , 44.24310362892123 , 17.507382176595957},
		{0.78 , 95.40116311082706 , 44.15883688917235 , 18.307976539211374},
		{0.79 , 97.00403679615188 , 44.035963203849306 , 19.116849400948944},
		{0.8 , 98.56142397202643 , 43.87857602797367 , 19.96280235465868},
		{0.81 , 100.06910387266848 , 43.69089612733089 , 20.816498011571948},
		{0.8200000000000001 , 100.28223336001054 , 42.946988045179275 , 21.707096148298252},
		{0.8300000000000001 , 100.26886159731217 , 42.132861678632096 , 22.604537181595123},
		{0.84 , 100.25424071477076 , 41.364553270029866 , 23.50801926114214},
		{0.85 , 100.23839939202564 , 40.6449773447736 , 24.41669703132928},
		{0.86 , 100.22880375194586 , 39.969493550588695 , 25.36018049342647},
		{0.87 , 100.20936321982154 , 39.33676014076924 , 26.307244206449052},
		{0.88 , 100.18267247064827 , 38.77070560798231 , 27.22616768765805},
		{0.89 , 100.16772776760533 , 38.271080273931744 , 28.177146318021403},
		{0.9 , 100.14958474422247 , 37.82088659319456 , 29.159138949462854},
		{0.91 , 100.1205985220036 , 37.43633217905522 , 30.10958807122717},
		{0.92 , 100.09904226658955 , 37.12704671895559 , 31.08855686353223},
		{0.93 , 100.07011210514172 , 36.88839103867991 , 32.03364059852231},
		{0.9400000000000001 , 100.04551280065202 , 36.72696859198815 , 33.00453119053536},
		{0.9500000000000001 , 100.01776754346375 , 36.63965578221561 , 33.99940237957164},
		{0.96 , 99.98824529887858 , 36.633644926512844 , 34.95661039771894},
		{0.97 , 99.95285587935045 , 36.70903434604495 , 35.93458754065069},
		{0.98 , 99.91258498054054 , 36.869305244854516 , 36.90188532157494},
		{0.99 , 99.86766124410332 , 37.1142289812932 , 37.857121480222645},
		{1.0 , 99.81816272913915 , 37.44372749625264 , 38.79894787890362},
		{1.01 , 99.64299546476288 , 37.81889476062747 , 39.75390789222921},
		{1.02 , 99.34148798652764 , 38.240402238867766 , 40.691866580434976},
		{1.03 , 98.9203256373014 , 38.70156458809183 , 41.611503243357454},
		{1.04 , 98.48897551587845 , 39.252914709512666 , 42.53772369051306},
		{1.05 , 98.05573596671327 , 39.886154258680314 , 43.416382178736804},
		{1.06 , 97.62193839969969 , 40.59995182569209 , 44.2979736749549},
		{1.07 , 97.1795163780539 , 41.402373847342574 , 45.155195437520966},
		{1.08 , 96.73912396746218 , 42.282766257931065 , 45.986991403433116},
		{1.09 , 96.30276917802337 , 43.23912104737863 , 46.79238929329313},
		{1.1 , 95.8599746326821 , 44.28191559271436 , 47.59232287085571},
		{1.11 , 95.41101260774947 , 45.41087761764089 , 48.36251205392745},
		{1.12 , 94.96955226425601 , 46.61233796114193 , 49.10217034792273},
		{1.1300000000000001 , 94.52340665615169 , 47.89848356924438 , 49.82982479762173},
		{1.1400000000000001 , 94.08762005251424 , 49.254270172872744 , 50.50551328262746},
		{1.1500000000000001 , 93.66367114768143 , 50.678219077711795 , 51.16620629648163},
		{1.16 , 93.2224776533825 , 52.19941257200579 , 51.80861062552524},
		{1.17 , 92.79470136941293 , 53.787188855975174 , 52.39848587521558},
		{1.18 , 92.3815067471836 , 55.440383478207494 , 52.96734911452344},
		{1.19 , 91.95131743016317 , 57.19057279523502 , 53.511928905756996},
		{1.2 , 91.53668973622285 , 59.00520048917478 , 54.00405654083297},
		{1.21 , 91.13833560811725 , 60.8835546172796 , 54.469447926766016},
		{1.22 , 90.72261931909871 , 62.859270906294526 , 54.904875652170986},
		{1.23 , 90.30599711814635 , 64.91589310724831 , 55.297794286442965},
		{1.24 , 89.90565623526744 , 67.03623399012578 , 55.64817235490576},
		{1.25 , 89.52167470250212 , 69.2202155228933 , 55.956023346071156},
		{1.26 , 89.0295311554749 , 71.43235906991693 , 56.23355502694578},
		{1.27 , 88.45045983623437 , 73.65143038915957 , 56.459406118128136},
		{1.28 , 87.80617161285942 , 75.85571861253308 , 56.64472642220054},
		{1.29 , 87.08245885725896 , 78.05943136813066 , 56.783616783842305},
		{1.3 , 86.30095064518126 , 80.2409395802134 , 56.876268714047995},
		{1.31 , 85.4652246623682 , 82.39666556301844 , 56.92289691702726},
		{1.32 , 84.5607759958518 , 84.54111422953784 , 56.923201120271564},
		{1.33 , 83.59111864815343 , 86.67077157724266 , 56.875785505165915},
		{1.34 , 82.57776323218667 , 88.76412699320511 , 56.78094578116016},
		{1.35 , 81.50645840467216 , 90.83543182072319 , 56.63514057675727},
		{1.36 , 80.39865211614718 , 92.86323810923949 , 56.44534507148376},
		{1.37 , 79.2755511162279 , 94.82633910917333 , 56.20915883020332},
		{1.3800000000000001 , 78.10582651446526 , 96.75606371093009 , 55.91987122329496},
		{1.3900000000000001 , 76.89389871308215 , 98.64799151231749 , 55.58288370886222},
		{1.4000000000000001 , 75.67828498425241 , 100.46360524113932 , 55.207948172352104},
		{1.41 , 73.36170639368314 , 100.68819296632103 , 54.788443433649974},
		{1.42 , 70.99175972022904 , 100.64891964056515 , 54.33620221523859},
		{1.43 , 68.77193644893882 , 100.62610286513551 , 53.84254246870001},
		{1.44 , 66.67425330977795 , 100.5882317359223 , 53.321282966772976},
		{1.45 , 64.72796299700155 , 100.5515115982149 , 52.77588169520084},
		{1.46 , 62.9112101945229 , 100.52934324009904 , 52.19473176616419},
		{1.47 , 61.20176019263384 , 100.49368303195571 , 51.59436483505697},
		{1.48 , 59.61251417347125 , 100.47136150119447 , 50.961397114639254},
		{1.49 , 58.124231296194395 , 100.4366966829492 , 50.31403832804485},
		{1.5 , 56.75917368626127 , 100.40314334555929 , 49.65541675346827},
		{1.51 , 55.49000970942241 , 100.39157929775199 , 48.95074549224063},
		{1.52 , 54.30169378245209 , 100.3481374352418 , 48.25755888727524},
		{1.53 , 53.23529906242502 , 100.32610461004381 , 47.54028746316895},
		{1.54 , 52.24628634537629 , 100.30347873954683 , 46.79979510555383},
		{1.55 , 51.335062334724434 , 100.28028068854395 , 46.0369975689197},
		{1.56 , 50.50915525125124 , 100.24941013090118 , 45.27492287113245},
		{1.57 , 49.780343166325224 , 100.2200671472029 , 44.51619500480034},
		{1.58 , 49.13095882626127 , 100.20391087206114 , 43.71713784756732},
		{1.59 , 48.54787478609182 , 100.17517914891722 , 42.92436958997607},
		{1.6 , 48.051895068204274 , 100.14820249843747 , 42.140256525059854},
		{1.61 , 47.62934330816636 , 100.13052641158987 , 41.31825566221281},
		{1.62 , 47.27108726216195 , 100.10457709207982 , 40.5076888347255},
		{1.6300000000000001 , 46.98936622041308 , 100.08057987792381 , 39.71062253069894},
		{1.6400000000000001 , 46.77444012627206 , 100.06201850210003 , 38.87820527147404},
		{1.6500000000000001 , 46.62079517635188 , 100.03944327069708 , 38.061829255405904},
		{1.6600000000000001 , 46.53210489956814 , 100.01937729119336 , 37.237351887723996},
		{1.67 , 46.50354510773815 , 99.99974101930573 , 36.431801308701594},
		{1.68 , 46.53225890125343 , 99.98139261625376 , 35.62039053298524},
		{1.69 , 46.607820237587084 , 99.94583127992158 , 34.80398176759718},
		{1.7 , 46.745538515744904 , 99.92811300176236 , 33.98343617550437},
		{1.71 , 46.944483724416976 , 99.92851895685631 , 33.15961078022979},
		{1.72 , 47.14986860748656 , 99.84313407377654 , 32.36003808386952},
		{1.73 , 47.35865361570385 , 99.674349065568 , 31.558950757066064},
		{1.74 , 47.623420710443064 , 99.52958197083453 , 30.75709835624473},
		{1.75 , 47.94322451519142 , 99.40977816608043 , 29.955216488264053},
		{1.76 , 48.312096285100814 , 99.3209063961652 , 29.18071231988101},
		{1.77 , 48.727991094939476 , 99.26501158633818 , 28.407486302191163},
		{1.78 , 49.19447725201892 , 99.23852542925869 , 27.636154003983666},
		{1.79 , 49.70455638027804 , 99.24844630099679 , 26.89377558824711},
		{1.8 , 50.2092781648707 , 99.18372451640259 , 26.12788323824725},
		{1.81 , 50.70640065091211 , 99.04660203035976 , 25.391810605103615},
		{1.82 , 51.18709660656913 , 98.84590607470275 , 24.65957164824185},
		{1.83 , 51.655723104120554 , 98.57727957715703 , 23.931623322729298},
		{1.84 , 52.10268386698659 , 98.25031881428968 , 23.23414414635253},
		{1.85 , 52.525462941570595 , 97.86753973970707 , 22.541430090454163},
		{1.86 , 52.98565910870211 , 97.52734357256402 , 21.853832217666262},
		{1.87 , 53.48269642029477 , 97.23030626097992 , 21.171681749478843},
		{1.8800000000000001 , 54.00791361580148 , 96.98508906547914 , 20.520235321879227},
		{1.8900000000000001 , 54.50293402417112 , 96.6900686570964 , 19.87438934660348},
		{1.9000000000000001 , 54.97398481335889 , 96.33901786791296 , 19.234387000528052},
		{1.9100000000000001 , 55.4110524612201 , 95.94195022005911 , 18.62472158526224},
		{1.92 , 55.81249530329818 , 95.50050737797223 , 18.0208543208301},
		{1.93 , 56.18505868369047 , 95.00794399757275 , 17.422957192483324},
		{1.94 , 56.52730647282338 , 94.46569620845132 , 16.83118815349905},
		{1.95 , 56.82951884451143 , 93.88348383677065 , 16.268989157741267},
		{1.96 , 57.09055061129528 , 93.26245206998233 , 15.712686687887288},
		{1.97 , 57.30929181315888 , 92.60371086811 , 15.185193645076371},
		{1.98 , 57.493003450695994 , 91.89999923056604 , 14.640731967285387},
		{1.99 , 57.64053570688181 , 91.15246697439291 , 14.124749933217387},
		{2.0 , 57.735077683970296 , 90.3779249973045 , 13.636568891071434},
		{2.0100000000000002 , 57.784159487278956 , 89.56884319400164 , 13.153686141275244},
		{2.02 , 57.79496285122973 , 88.71803983003925 , 12.676144684056801},
		{2.0300000000000002 , 57.75912720059074 , 87.83387548068555 , 12.225325890819745},
		{2.04 , 57.676344324601665 , 86.91665835666585 , 11.779433585903226},
		{2.05 , 57.55363908671686 , 85.9593635945507 , 11.338489201100531},
		{2.06 , 57.38323707405905 , 84.96976560721426 , 10.923157541823835},
		{2.07 , 57.16502858232458 , 83.94797409894726 , 10.51233938800861},
		{2.08 , 56.90577796664037 , 82.88722471463713 , 10.10604158467408},
		{2.09 , 56.59830779994669 , 81.79469488132368 , 9.724248748547268},
		{2.1 , 56.24265898738701 , 80.67034369388197 , 9.34653868819457},
		{2.11 , 55.838890264436074 , 79.51411241683579 , 8.992471979439498},
		{2.12 , 55.38712201611224 , 78.32588066515817 , 8.642063193760816},
		{2.13 , 54.887488111441655 , 77.10551456983922 , 8.314474842874876},
		{2.14 , 54.34604865596595 , 75.84695402531005 , 7.971159620917582},
		{2.15 , 53.75678113575179 , 74.5562215455216 , 7.669042358137642},
		{2.16 , 53.119925561901375 , 73.23307711937188 , 7.351180881538143},
		{2.17 , 52.44108950157608 , 71.87191317969433 , 7.054961357643277},
		{2.18 , 51.70961114005155 , 70.4833915412188 , 6.779839590633683},
		{2.19 , 50.93130809495521 , 69.06169458631958 , 6.507209517165668},
		{2.2 , 50.14541283373332 , 67.64758984753709 , 6.2370616692140475},
		{2.21 , 49.34729024110675 , 66.2457124401576 , 5.987154293575454},
		{2.22 , 48.53750877311531 , 64.85549390815943 , 5.739391727369608},
		{2.23 , 47.72105945923493 , 63.47194322203833 , 5.493764842100909},
		{2.24 , 46.89374025489964 , 62.09926242636773 , 5.267586701925111},
		{2.25 , 46.05607501913505 , 60.73692766214838 , 5.04323386167683},
		{2.2600000000000002 , 45.212591989504205 , 59.3804106917789 , 4.820698085909446},
		{2.27 , 44.35948682505626 , 58.03351585623043 , 4.616885874327883},
		{2.2800000000000002 , 43.497238766474204 , 56.69576391479183 , 4.414607800816956},
		{2.29 , 42.626307641315954 , 55.3666950399528 , 4.2305279011672585},
		{2.3000000000000003 , 41.75065271195813 , 54.04234996930822 , 4.031170368729604},
		{2.31 , 40.86694613926672 , 52.726056542011456 , 3.866195223483106},
		{2.32 , 39.97560729707973 , 51.41739538418926 , 3.6859309703774756},
		{2.33 , 39.080207583249404 , 50.112795098013386 , 3.523148120200873},
		{2.34 , 38.17774636928225 , 48.81525631198664 , 3.3614022787113487},
		{2.35 , 37.271555293268804 , 47.52144738799735 , 3.2006888767072668},
		{2.36 , 36.358841669118085 , 46.23416101215371 , 3.0569257235292366},
		{2.37 , 35.43996615235096 , 44.953036528923775 , 2.913991676709637},
		{2.38 , 34.51791844782682 , 43.675084233450676 , 2.7718832800507363},
		{2.39 , 33.592739177674645 , 42.40026350360267 , 2.6305970411878867},
		{2.4 , 32.662022363655936 , 41.13098031761886 , 2.5056966293569274},
		{2.41 , 31.726091594461383 , 39.8669110868133 , 2.381440538308904},
		{2.42 , 30.785258740623714 , 38.60774394065768 , 2.2732430233119114},
		{2.43 , 29.841997370911567 , 37.35100531035751 , 2.1501882295483017},
		{2.44 , 28.896335561192885 , 36.09666712008187 , 2.043037935071269},
		{2.45 , 27.946301014124835 , 34.84670166714693 , 1.9363736438087216},
		{2.46 , 26.99217548708388 , 33.600827194187886 , 1.8453326148834204},
		{2.47 , 26.034230092889523 , 32.35877258837915 , 1.7546462812860857},
		{2.48 , 25.074480992187407 , 31.118521689081394 , 1.6643135419857071},
		{2.49 , 24.112945134129554 , 29.880057547142208 , 1.5743332911982284},
		{2.5 , 23.149639388214943 , 28.6433632930541 , 1.4847044185598732},
		{2.5100000000000002 , 22.183063376381952 , 27.4099393048898 , 1.4102813011007764},
		{2.52 , 21.21346201061154 , 26.179540670657246 , 1.3361007747936462},
		{2.5300000000000002 , 20.242441230384365 , 24.95056145088456 , 1.2621621902813247},
		{2.54 , 19.268718301078504 , 23.7242843801899 , 1.2031850831736934},
		{2.5500000000000003 , 18.29374407844203 , 22.499258602829713 , 1.1296803514514453},
		{2.56 , 17.31752811969008 , 21.275474561587643 , 1.0710494793654384},
		{2.57 , 16.337919263548915 , 20.05508341772658 , 1.0271769709921783},
		{2.58 , 15.357365951870019 , 18.835636729399077 , 0.9688142174890473},
		{2.59 , 14.375873911870816 , 17.617128769394345 , 0.9251424112447103},
		{2.6 , 13.392573879020626 , 16.40042880225417 , 0.8815563829110276},
		{2.61 , 12.444456677205457 , 15.22854600406628 , 0.8380559898219032},
		{2.62 , 11.531568341285265 , 14.101434339989094 , 0.7946410891138693},
		{2.63 , 10.653266409181263 , 13.019736272090473 , 0.7657452471054711},
		{2.64 , 9.809765595401238 , 11.983237085867161 , 0.7368872957010016},
		{2.65 , 9.001842640697946 , 10.991160040573792 , 0.7080671924305906},
		{2.66 , 8.229526794647466 , 10.043475886629857 , 0.6792848947884783},
		{2.67 , 7.492847178050667 , 9.14015550322361 , 0.6505403602336899},
		{2.68 , 6.7913992799418255 , 8.281603401329912 , 0.6361822408104467},
		{2.69 , 6.125732127122476 , 7.46727055414926 , 0.6074942710464523},
		{2.7 , 5.495867120492436 , 6.6971355607793 , 0.5931644100490108},
		{2.71 , 4.901514202538938 , 5.971488478732796 , 0.5788439578667581},
		{2.72 , 4.343077682556171 , 5.2899249987155645 , 0.5645329091661457},
		{2.73 , 3.8205715420743602 , 4.652431139194797 , 0.550231258611704},
		{2.74 , 3.334009731127251 , 4.058992950144484 , 0.550231258611704},
		{2.75 , 2.8830414473508768 , 3.5099612339208583 , 0.5359390008657371},
		{2.7600000000000002 , 2.4684628612301234 , 3.0045398200416114 , 0.5216561305888697},
		{2.77 , 2.0898655929867282 , 2.5431370882850066 , 0.5216561305888697},
		{2.7800000000000002 , 1.7470430306147304 , 2.125959650657005 , 0.5216561305888697},
		{2.79 , 1.4403070537555742 , 1.752695627516161 , 0.5073826424393858},
		{2.8000000000000003 , 1.1698052567394899 , 1.4231974245322454 , 0.5073826424393858},
		{2.81 , 0.9352128523821618 , 1.1377898288895734 , 0.5073826424393858},
		{2.82 , 0.7367115871567304 , 0.8962910941150048 , 0.5073826424393858},
		{2.83 , 0.5743014610631956 , 0.6987012202085398 , 0.5073826424393858},
		{2.84 , 0.44798247410155745 , 0.545020207170178 , 0.5073826424393858},
		{2.85 , 0.3577546262718159 , 0.4352480549999195 , 0.4931185310739024},
		{2.86 , 0.30365618142456263 , 0.3693464998471728 , 0.4931185310739024},
		{2.87 , 0.28560833764178534 , 0.34739434362995003 , 0.4931185310739024},
		{2.88 , 0.23146480629345365 , 0.28153787497828175 , 0.4931185310739024},
		{2.89 , 0.14122558737956742 , 0.17177709389216797 , 0.4931185310739024},
		{2.9 , 0.0 , 0.0 , 0.4931185310739024}
	};
}