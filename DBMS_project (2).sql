CREATE DATABASE Project;
USE Project;
SHOW DATABASES;
DROP TABLE Organizing_Committee;
DROP TABLE Student_Council;
DROP TABLE Organizing_Team;
DROP TABLE Volunteers;
DROP TABLE Management;
DROP TABLE Associates;
DROP TABLE Events;
DROP TABLE Contacts;
DROP TABLE Judges;
DROP TABLE Requirements;
DROP TABLE Participants;
DROP TABLE Sponsors;
DROP TABLE Expenditures;
SHOW TABLES;
CREATE TABLE Student_Council
	(
		roll_no INT NOT NULL,
        name VARCHAR(25) NOT NULL,
        position VARCHAR(25) NOT NULL,
        email VARCHAR(50) NOT NULL,
        contact VARCHAR(10) NOT NULL,
        CGPA NUMERIC(3,1) NOT NULL,
        PRIMARY KEY(roll_no)
);
CREATE TABLE Organizing_Committee
	(
		roll_no INT NOT NULL,
        name VARCHAR(25) NOT NULL,
        dept VARCHAR(25) NOT NULL,
        email VARCHAR(50) NOT NULL,
        contact VARCHAR(10) NOT NULL,
        experience VARCHAR(100) NOT NULL,
		CGPA NUMERIC(3,1) NOT NULL,
        PRIMARY KEY(roll_no)
);
CREATE TABLE Organizing_Team
	(
		roll_no INT NOT NULL,
        name VARCHAR(25) NOT NULL,
        dept VARCHAR(25) NOT NULL,
        event VARCHAR(25) NOT NULL,
		email VARCHAR(50) NOT NULL,
        contact VARCHAR(10) NOT NULL,
        respective_OC INT NOT NULL,
        PRIMARY KEY(roll_no),
        FOREIGN KEY(respective_OC) references Organizing_Committee(roll_no),
        FOREIGN KEY(event) references Events(name) 
);
CREATE TABLE Volunteers
	(
		roll_no INT NOT NULL,
        name VARCHAR(25) NOT NULL,
        email VARCHAR(50) NOT NULL,
        contact VARCHAR(10) NOT NULL,
        respective_OC INT NOT NULL,
        respective_OT INT NOT NULL,
        PRIMARY KEY(roll_no),
        FOREIGN KEY(respective_OC) references Organizing_Committee(roll_no),
        FOREIGN KEY(respective_OT) references Organizing_Team(roll_no) 
);
CREATE TABLE Management
	(
		id INT AUTO_INCREMENT NOT NULL,
        name VARCHAR(25) NOT NULL,
        type VARCHAR(50) NOT NULL,
        contact_1 VARCHAR(10) NOT NULL,
        contact_2 VARCHAR(10) NOT NULL,
        PRIMARY KEY(id)
);
CREATE TABLE Sponsors
	(
		id INT AUTO_INCREMENT NOT NULL,
        name VARCHAR(25) NOT NULL,
		contact VARCHAR(10) NOT NULL,
        address VARCHAR(100) NOT NULL,
        point_of_contact INT NOT NULL,
        mode_of_spons VARCHAR(25),
        status VARCHAR(25) NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(point_of_contact) references Organizing_Team(roll_no)
);
CREATE TABLE Participants
	(
		id INT AUTO_INCREMENT NOT NULL,
        name VARCHAR(25) NOT NULL,
        college VARCHAR(50) NOT NULL,
		contact VARCHAR(10) NOT NULL,
		event VARCHAR(25) NOT NULL,
        status VARCHAR(50) NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(event) REFERENCES Events(name)
);
CREATE TABLE Events
	(
		name VARCHAR(25) NOT NULL,
        dept VARCHAR(50) NOT NULL,
        status VARCHAR(50) NOT NULL,
        prizes VARCHAR(100) NOT NULL,
        location VARCHAR(75) NOT NULL,
        PRIMARY KEY(name)
);
CREATE TABLE Judges
	(
		name VARCHAR(25) NOT NULL,
        point_of_contact VARCHAR(50) NOT NULL,
        event VARCHAR(25) NOT NULL,
        fee INT NOT NULL,
        PRIMARY KEY(name),
        FOREIGN KEY(event) REFERENCES Events(name)
);
CREATE TABLE Associates
	(
		id INT AUTO_INCREMENT NOT NULL,
		name VARCHAR(25) NOT NULL,
        institute VARCHAR(50) NOT NULL,
        incharge_OC INT NOT NULL,
        timings VARCHAR(50) NOT NULL,
        fee INT,
        PRIMARY KEY(id),
        FOREIGN KEY(incharge_OC) REFERENCES Organizing_Committee(roll_no)
);
CREATE TABLE Contacts
	(
		id INT AUTO_INCREMENT NOT NULL,
		name VARCHAR(25) NOT NULL,
        dept VARCHAR(25) NOT NULL,
        status VARCHAR(50) NOT NULL,
        college VARCHAR(50) NOT NULL,
        contacted_by INT NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(contacted_by) REFERENCES Organizing_Team(roll_no)
);
CREATE TABLE Expenditures
	(
		id INT AUTO_INCREMENT NOT NULL,
		money_spent INT NOT NULL,
        incharge INT NOT NULL,
        balance INT NOT NULL,
        purpose VARCHAR(50) NOT NULL,
        PRIMARY KEY(id),
        FOREIGN KEY(incharge) references Organizing_Committee(roll_no)
);
CREATE TABLE Requirements
	(
		id INT AUTO_INCREMENT NOT NULL,
		name VARCHAR(50) NOT NULL,
        total_reqd INT NOT NULL,
        available INT NOT NULL DEFAULT 0,
        events VARCHAR(255) NOT NULL,
        purpose VARCHAR(255) NOT NULL,
        vendor VARCHAR(50) NOT NULL,
		PRIMARY KEY(id)
);
show warnings;
insert into Organizing_Committee values
		(2016123, 'Aman', 'Mentor',  'aman16123@abc.in', 9999111102, 'Operations OC', 7.8 ),
		(2016223, 'Arjun', 'Convenor',  'arjun16223@abc.in', 9876354524, 'Convener OC', 8.5),
		(2016100, 'Priyanka', 'Convenor',  'priyanka16100@abc.in', 8787335526, 'Publicity OC', 8.2),
		(2017100, 'Manpreet', 'Lifestyle',  'manpreet17100@abc.in', 9876559960, 'PR OC', 7.6),
		(2017280, 'yashwin', 'Dance',  'yashwin17280@abc.in', 9090876453, 'Battle troupe OT', 9),
		(2017006, 'gagan', 'Music',  'gagan17006@abc.in', 9846357728, 'battle of Bands OT', 8.3),
		(2018190, 'olivia', 'literary',  'olivia18190@abc.in', 9868447738, 'Publicity OC', 8.8),
		(2017099, 'karan', 'publicity',  'karan17099@abc.in', 9000475611, 'Publicity OT', 7.2),
		(2018321, 'ishita', 'PR',  'ishita18321@abc.in', 9990374611, 'Literary Events OT', 7.4),
		(2016092, 'aryan', 'operations',  'aryan16092@abc.in', 9876445539, 'Mentor OC', 8.6);
        
insert into Events values
		('Battle Troupe','Dance','50,000','judge table','OAT'),
		('Street Dance','Dance','20000','rope','Emma stone'),
		('Solo Dance','Dance','15000','judge table','OAT'),
		('Battle of Bands','Music','30000','Sound check','Mainstage'),
		('rap battles','Music','12000','mic check','secondary stage'),
		('Acapella','Music','15000','room acoustics','C21'),
		('Reverbe','Lifestyle','30000','Lighting','C102'),
		('HuntIT','Lifestyle','80000','Checking  ','campus'),
		('Ms Odyssey','Lifestyle','10000','Checking','secondary stage '),
		('Mr Odyssey','Lifestyle','10000','Checking','secondary stage'),
		('16WTG','Literary','15000','Checking','online'),
		('Punchline','Literary','10000','mic check','C01'),
		('slam poetry','Literary','20000','Checking','C11 ');

insert into Organizing_Team values
		(2018320,'Deep Pratap Raj','Dance','Battle Troupe','deep18320@iiitd.ac.in',0426667964,2017280),
		(2018292,'Nakul Raj Harjo','Dance','Battle Troupe','nakul18292@iiitd.ac.in',9879688709,2017280),
		(2018056,'Abbas Natwar Kuruvilla','Dance','Battle Troupe','abbas18056@iiitd.ac.in',0898058036,2017280),
		(2019086,'Arvind Venkataraman','Dance','Street Dance','arvind19086@iiitd.ac.in',4788726009,2017280),
		(2019187,'Aniruddh Chaudhry','Dance','Street Dance','aniruddh19187@iiitd.ac.in',04203335687,2017280 ),
		(2019323,'Rajesh Dhawan','Dance','Solo Dance','rajesh19323@iiitd.ac.in',9824316429,2017280),
		(2019287,'Aastha Mahadeo','Dance','Solo Dance','aastha19287@iiitd.ac.in',09750635454,2017280),
		(2019112 ,'Hassan Krishnamurthy','Dance','Solo Dance','hassan19112@iiitd.ac.in',0958246708,2017280),
		(2018421,'Chinmay Chokshi','Music','Battle of Bands','chinmay18421@iiitd.ac.in',0941510222,2017006),
		(2018369,'Ujwal Tella','Music','Battle of Bands','ujwal18369@iiitd.ac.in',09252254607,2017006 ),
		(2018034,'Laveena Ganesan','Music','rap battles','laveena18034@iiitd.ac.in',06203984144,2017006),
		(2018132,'Radhe Prasad','Music','rap battles','radhe18132@iiitd.ac.in',9803114960,2017006),
		(2019221,'Madhu Bhatia','Music','rap battles','madhu19221@iiitd.ac.in',0732744048,2017006),
		(2019396,'Venkat Dhawan','Music','Acapella','venkat19396@iiitd.ac.in',4098797965,2017006),
		(2018321,'Fakaruddin Chohan','Lifestyle','Reverbe','fakaruddin18321@iiitd.ac.in',09459110896,2017100),
		(2018256,'Nitin Mital','Lifestyle','Reverbe','nitin18256@iiitd.ac.in',08387145001,2017100),
		(2018066,'Kushal Srinivas','Lifestyle','Reverbe','kushal18366@iiitd.ac.in',0969876600,2017100),
		(2018313,'Kirti Kumar','Lifestyle','HuntIT','kirti18313@iiitd.ac.in',9748695470,2017100),
		(2019169,'Raj Lal','Lifestyle','HuntIT','raj19169@iiitd.ac.in',0975578581,2017100),
		(2019125,'Abhinav Bhattacharyya','Lifestyle','Ms Odyssey','abhinav19125@iiitd.ac.in',0968467947,2017100),
		(2019276,'Ramesh','Lifestyle','Ms Odyssey','ramesh19276@iiitd.ac.in',0834585843,2017100),
		(2018366,'Aarif Baldev','Lifestyle','Mr Odyssey','aarif18366@iiitd.ac.in',06819160621,2017100),
		(2018243,'Krishna Prasad','Lifestyle','Mr Odyssey','krishna18243@iiitd.ac.in',9766066356,2017100),
		(2019163,'Hrishikesh Naseer','Lifestyle','Mr Odyssey','hrishikesh19163@iiitd.ac.in',9595294866,2017100),
		(2018327,'Suresh Memon','Literary','16WTG','suresh18327@iitd.ac.in',0938083852,2018190),
		(2018133,'Yasmin Abhina','Literary','16WTG','yasmin18132@iiitd.ac.in',09545116274,2018190),
		(2018409,'Nutan Kota','Literary','16WTG','nutan18409@iiitd.ac.in',09619001968,2018190),
		(2019267,'Afreen Marlo','Literary','16WTG','afreen19267@iiitd.ac.in',0942371912,2018190),
		(2019071,'Surya Singh','Literary','Punchline','surya19071@iiitd.ac.in',0967094868,2018190),
		(2019162,'Karim Singh','Literary','Punchline','karim19162@iiitd.ac.in',0968822772,2018190),
		(2018287,'Jyoti Ghalib','Literary','slam poetry','jyoti18287@iiitd.ac.in',9407963733,2018190),
		(2018212,'Umar Ghosh','Literary','slam poetry','umar18212@iiitd.ac.in',0948979255,2018190),
		(2019281,'Abhinav Rege','Literary','slam poetry','abhinav19281@iiitd.ac.in',0983543162,2018190);

insert into Judges values 
		('MJ5', 2018320, 'Battle Troupe', 25000),
		('Dytto', 2019187, 'Street Dance', 0),
		('Prabhudeva', 2019112, 'Solo Dance', 50000),
		('AC/DC', 2018369, 'Battle of Bands', 100000),
		('Eminem', 2018034, 'rap battles', 0),
		('Sonu Nigam', 2019396, 'Acapella', 25000),
		('Lata Mangeshkar', 2019396, 'Acapella', 0),
		('Prateek Kuhad', 2018256, 'Reverbe', 15000),
		('Javed Akhtar', 2018132, '16WTG', 0),
		('Chetan Bhagat', 2018212, 'slam poetry', 0),
		('Hindustani Bhau', 2019162, 'Punchline', 10000); 
        
insert into Sponsors values 
		(1, 'Janyx', 1009295470, '07510 Cottonwood Alley', 2019187, 'Money', 'final'),
		(2, 'Skilith', 9829201287, '1807 Pond Way', 2018421, 'Money/Stall', 'working'),
		(3, 'Demimbu', 2420980204, '402 Jenifer Place', 2019396, 'Money', 'cancel'),
		(4, 'Oloo', 8604187952, '90700 Maywood Way', 2018366, 'Inkind', 'final'),
		(5, 'Bubbletube', 426580303, '043 Schlimgen Avenue', 2018313, 'Inkind', 'final'),
		(6, 'Twitterbridge', 141884282, '2205 Marcy Street', 2019221, 'Inkind', 'working'),
		(7, 'Feedspan', 134302303, '18751 Canary Point', 2018421, 'Stall', 'cancel'),
		(8, 'Brightdog', 7346388828, '7 Talmadge Lane', 2019071, 'Stall', 'cancel'),
		(9, 'Skyndu', 4429061688, '8 Butternut Point', 2018212, 'Money', 'final'),
		(10, 'Devpulse', 1643960458, '8753 Washington Junction', 2019281, 'Money', 'final');
        

insert into Volunteers values
		(2017001,'Claudius Sandaver','csandaver0@rakuten.co.jp',3339667837,2018190,2019281),
		(2017002,'Jeanette Stegell','jstegell1@fc2.com',2706351799,2018190,2018212),
		(2017003,'Chandal Di Batista','cdi2@wix.com',3156263796,2018190,2018287),
		(2017004,'Jobina Gabotti','jgabotti3@dot.gov',3232361854,2018190,2019162),
		(2017005,'Marlee Knoles','mknoles4@xrea.com',9277863420,2018190,2019162),
		(2017040,'Arlyne Oglevie','aoglevie5@desdev.cn',7300032508,2018190,2019071),
		(2017007,'Zed Couser','zcouser6@weebly.com',6471085338,2018190,2019267),
		(2017008,'Sibley Shobbrook','sshobbrook7@mediafire.com',4961770698,2018190,2018409),
		(2017009,'Todd Cameli','tcameli8@linkedin.com',7397245137,2018190,2018132),
		(2017010,'Adel Chasteney','achasteney9@berkeley.edu',2891358570,2017100,2019163),
		(2017011,'Ewart McAleese','emcaleesea@utexas.edu',5974786912,2017100,2018243),
		(2017012,'Georgena Foot','gfootb@state.tx.us',9547473778,2017100,2018366),
		(2017013,'Corinna Reisenberg','creisenbergc@java.com',818828501,2017100,2019169),
		(2017014,'Sib Gilliat','sgilliatd@fotki.com',8696115074,2017100,2018313),
		(2017015,'Emylee Bradnam','ebradname@blogger.com',7435885622,2017100,2018313),
		(2017016,'Domeniga Peakman','dpeakmanf@sciencedaily.com',7918718151,2017100,2018366),
		(2017018,'Dave Drew-Clifton','ddrewcliftonh@exblog.jp',6623149740,2017100,2018321),
		(2017019,'Andy Geffen','ageffeni@hostgator.com',6329541345,2017006,2019396),
		(2017020,'Noni Capsey','ncapseyj@vimeo.com',5038647499,2017006,2019396),
		(2017021,'Cris Rotherforth','crotherforthk@altervista.org',2227530472,2017006,2019396),
		(2017022,'Kelli Reggler','kregglerl@networksolutions.com',7875444055,2017006,2018132),
		(2017023,'Bobbie Troppmann','btroppmannm@nature.com',4841440003,2017006,2018034),
		(2017024,'Teddi Beals','tbealsn@reuters.com',5511530131,2017006,2018132),
		(2017026,'Mischa Bloore','mbloorep@amazon.de',7641085989,2017006,2018369),
		(2017027,'Munmro Fosbraey','mfosbraeyq@howstuffworks.com',9311869589,2017006,2018421),
		(2017028,'Foster Underwood','funderwoodr@gmpg.org',9058602605,2017280,2019112),
		(2017029,'Valenka Creber','vcrebers@xrea.com',6985606865,2017280,2019287),
		(2017030,'Zea Ellershaw','zellershawt@so-net.ne.jp',607879645,2017280,2019323),
		(2017031,'Alberta Fisher','afisher0@ucla.edu',4876894191,2017280,2019086),
		(2017032,'Kennett Blaber','kblaber1@people.com.cn',8735703938,2017280,2019187),
		(2017033,'Gerhardt Thurber','gthurber2@sakura.ne.jp',9379607415,2017280,2019187),
		(2017034,'Brant Branthwaite','bbranthwaite3@privacy.gov.au',1649588097,2017280,2018056),
		(2017035,'Laetitia Ventam','lventam4@nba.com',3812600420,2017280,2018292),
		(2017036,'Cristiano Nossent','cnossent5@behance.net',8819376695,2017280,2018320);
        
insert into Associates values
		(1,'Devinne Phelipeau','Oyonder',2016123,'7:24 AM',8076),
		(2,'Kitti Feldberg','Feedspan',2016223,'1:56 AM',3912),
		(3,'Nicky Peasegod','Linktype',2016100,'1:09 AM',8083),
		(4,'Rhetta Panswick','Zoonder',2017100,'10:11 PM',13576),
		(5,'Freddi English','Fatz',2017280,'11:07 PM',16143),
		(6,'Tabbitha Skillen','Browsedrive',2017006,'1:08 PM',8572),
		(7,'Tamma Ferrierio','Skynoodle',2018190,'2:31 PM',3486),
		(8,'Federico Cashford','Brainverse',2017099,'6:58 PM',7906),
		(9,'Kat Keast','Gabtype',2018321,'4:39 AM',4513),
		(10,'Shela Elam','Yamia',2016092,'1:12 AM',4799);
        
insert into Expenditures values
		(1,1000,2017006,200000,'sheets'),
		(2,16000,2018190,184000,'tent covers'),
		(3,5000,2017099,179000,'lights'),
		(4,45000,2018321,134000,'stage'),
		(5,4000,2016092,130000,'lights'),
		(6,2000,2016123,128000,'tent poles'),
		(7,27000,2016223,101000,'tent covers'),
		(8,8500,2016100,92500,'chairs'),
		(9,1000,2017100,91500,'flex'),
		(10,11500,2017280,80000,'tables');
        
insert into Participants values
		(1,'Anshul','Amity',9873455913,'Street Dance','briefed about prelims'),
		(2,'Meenali','Deen Dayal Upadhyaya',8376065527,'Street Dance','briefed about prelims'),
		(3,'tanishq','delhi college of arts and commerce',9599922792,'Solo Dance','called'),
		(4,'shikha gupta','amity noida',9899199219,'Solo Dance','called; seemed enthusiastic'),
		(5,'rashi','gargi college ',8130672632,'Battle of Bands','WRONG CONTACT'),
		(6,'Nishul Gupta','SRCC',9650608973,'Battle of Bands','enthusiastic, brochures sent'),
		(7,'simran walia','army institute of law',7973253972,'rap battles','Called'),
		(8,'Nikita Goel','SGGSCC',9954200035,'rap battles','Received new contact - Muskan - +91 9315592143'),
		(9,'Suraj','Artmandir',7829953236,'acapella','Paid the registration fee'),
		(10,'Nikita Mohite','Hansraj College',9899294392,'acapella','briefed about prelims'),
		(11,'Bedanga Das','IIT Kanpur',8474899363,'reverbe','Not paid yet'),
		(12,'sk gupta','benaras hindu university',9415812879,'reverbe','asking for timings'),
		(13,'manish shukla','bennett university',9599022036,'HuntIT','Will come'),
		(14,'Leena','Indraprastha College for Women',8582947847,'HuntIT','Graduated but might come'),
		(15,'Shubhali','bharati college',8348154538,'Ms Odyssey','called'),
		(16,'RUPALI','KMV,PITAMPURA ',9811920838,'Ms Odyssey','called'),
		(17,'Manik','LSR',09811681481,'Mr Odyssey','called'),
		(18,'Nikita','LIC',9205241908,'Mr Odyssey','called'),
		(19,'payal','bhartiya vidyapeeth',8076266010,'16WTG','Unable to contact'),
		(20,'Shubhi','Maharaja Agrasen Institute of Technology ',7982161837,'16WTG','ask details on whatsapp'),
		(21,'suda jain','AISSMS pune',7219286100,'Battle Troupe','Exams; cancelled registration'),
		(22,'RAHUL KINRA','chitkaara university  EPIC',7357588720,'Battle Troupe','slot confirmed'),
		(23,'Punya Sethi','Maitreyi',9810130055,'Punchline','payment confirmed'),
		(24,'Ashish Singh ','BIT mesera',8619472302,'Punchline','briefed about prelims'),
		(25,'Aanchal', 'BR ambedkar College',9958092878,'slam poetry','called'),
		(26,'Rhea','Miranda House',9650348242,'slam poetry','Positive response'),
		(27,'Shachi Solanki','NLU Delhi',9810593747,'slam poetry','new contacts');

insert into Requirements values
		(1,'pens',25,4,'NULL','general','Jamia'),
		(2,'tables',22,1,'Solo Dance, rap battle, Mr Odyssey','NULL','Rhycero'),
		(3,'tables',16,5,'NULL','registration desks','Tagopia'),
		(4,'chairs',9,10,'NULL','registration desks','Twimm'),
		(5,'chairs',12,6,'Battle of Bands, acapella','NULL','Avamm'),
		(6,'food boxes',15,1,'NULL','refreshments','Yamia'),
		(7,'bottle packs',13,11,'all events','NULL','Vipe'),
		(8,'pads',15,6,'NULL','records management','Latz'),
		(9,'covers',14,8,'Solo Dance, rap battle, Mr Odyssey','stalls and judges\' tables','Janyx'),
		(10,'posters',260,130,'20 each','publicity','Skidoo');

insert into Contacts values
		(1,"Deck Clorley","Dance","TRUE","Northrise University",2018320),
		(2,"Paloma Frayn","Tech","TRUE","Academy of Fine Arts, School of Architecture",2018320),
		(3,"Carla Olivetta","Singing","FALSE","Bugema University",2018320),
		(4,"Wilhelm Ternent","Rebuttle","FALSE","Free University of Tbilisi",2018292),
		(5,"Monro Felten","Verve","TRUE","University of Insurance and Banking in Warsaw",2018292),
		(6,"Krystle Tilberry","Hackaroo","TRUE","Conestoga College",2019086),
		(7,"Ansley Dreamer","Rap Battle","FALSE","University of Delaware",2019086),
		(8,"Ninette Gatch","Reverbe","TRUE","University of Central Lancashire",2019323),
		(9,"Merline Cassimer","Campus Princess","FALSE","University of Manila",2019323),
		(10,"Joeann Piwall","Acapella","FALSE","Escuela Militar de IngenierÃ­a",2019323),
		(11,"Ty Byrd","Street Dance","TRUE","Universidade de Santo Amaro",2018421),
		(12,"Winona McChesney","Rebuttle","TRUE","Southeastern Oklahoma State University",2018421),
		(13,"Dorian Shimoni","Verve","FALSE","Kardan University",2018421),
		(14,"Enrique Ditchfield","Hackaroo","FALSE","National Chung Cheng University",2018034),
		(15,"Aileen Shemmans","Rap Battle","FALSE","State University of New York College at Geneseo",2018034),
		(16,"Delora Mouse","Reverbe","FALSE","Devry Institute of Technology",2018034),
		(17,"Inez Mourton","Campus Princess","FALSE","Benguet State University",2018369),
		(18,"Dane Danilowicz","Acapella","TRUE","Guangzhou Academy of Fine Art",2018369),
		(19,"Montgomery Maplethorpe","Street Dance","TRUE","Preston University",2018369),
		(20,"Janeta Osborn","Verve","TRUE","Uzbek State World Languages University",2019221),
		(21,"Karyn Keefe","Hackaroo","FALSE","John Brown University",2019221),
		(22,"Irving Senner","Rap Battle","FALSE","University of Veterinary Medicine in Kosice",2019396),
		(23,"Clarence Trudgeon","Reverbe","TRUE","Hyrcania Institute of Higher Education",2019396),
		(24,"Maridel Randal","Campus Princess","TRUE","University of Oulu",2018366),
		(25,"Noak Spackman","Acapella","FALSE","Islamic Azad University, Roodehen",2018366),
		(26,"Bondie Moggach","Street Dance","TRUE","Universidad FrancoNULLMexicana",2018366),
		(27,"Delila Adamou","Verve","FALSE","Libya Open University",2018313),
		(28,"Laughton Linklet","Hackaroo","TRUE","Nara University of Education",2018313),
		(29,"Malissia Craigmyle","Rap Battle","FALSE","University of Exeter",2019169),
		(30,"Zebulon Bavin","Reverbe","TRUE","Universidad de La Salle",2019169),
		(31,"Ulrica Kernermann","Campus Princess","FALSE","International School of Management in PreÅ¡ov",2019276),
		(32,"Alick Gostick","Acapella","FALSE","Regent University",2019276),
		(33,"Hubert Spoor","Street Dance","TRUE","SRCC",2019163),
		(34,"Jenifer Newling","Street Dance","FALSE","Institut SupÃ©rieure d'Electronique de Paris",2018132),
		(35,"Thorsten Yaldren","Verve","FALSE","International University of Japan",2018132),
		(36,"Alain Hammel","Hackaroo","FALSE","Tatung Institute of Technology",2018132),
		(37,"Modestia Deppen","Rap Battle","TRUE","Istanbul Technical University",2019071),
		(38,"Janela Palffy","Reverbe","FALSE","Delhi College of Engineering (DCE)",2019071),
		(39,"Carri McNamee","Campus Princess","FALSE","Universidad San Juan de la Cruz",2018287),
		(40,"Thom Byars","Acapella","TRUE","Lutheran School Of Theology In Aarhus",2018287);

insert into Management values(1,"Estevan Mellhuish","Electrician",8727188159,6722920534);
insert into Management values(2,"Maximilian Nossent","Electrician",7405803008,1077446462);
insert into Management values(3,"Aarika Perrycost","Security",2120072809,8461590198);
insert into Management values(4,"Chris Caveth","Security",860374440,6722920534);
insert into Management values(5,"Willdon Yerrington","Plumber",7162466281,1321979290);
insert into Management values(6,"Trace Itzhaiek","Plumber",2771934337,1580937330);
insert into Management values(7,"Beaufort Coats"," Cleaning",8736737828,5336655759);
insert into Management values(8,"Herold Garman","Cleaning",9885785809,7608026995);
insert into Management values(9,"Corine Purkis","Carpentar",6221924073,4258899879);
insert into Management values(10,"Paton Feare","Carpentar",9617695499,7405803008);


insert into Student_Council values(2018314,"Adelice","member","acapelen8@ycombinator.com",2814458744,8.7);
insert into Student_Council values(2017456,"Skip","member","sedmeads9@google.com",7405803008,8.5);
insert into Student_Council values(2019231,"Marlena","head","mrutherfortha@cam.ac.uk",2120072809,9.5);
insert into Student_Council values(2018567,"AnneNULLcorinne","member","aschaperob@squarespace.com",860374440,9.1);
insert into Student_Council values(2017345,"Kinny","member","kmitchamc@istockphoto.com",7162466281,9.1);
insert into Student_Council values(2017234,"Vanya","head","vmapsond@hibu.com",8736737828,8.2);
insert into Student_Council values(2017123,"Herculie","member","hfolie@4shared.com",9885785809,8.7);
insert into Student_Council values(2017001,"Saloma","head","sburgwinf@youku.com",6221924073,8.2);
insert into Student_Council values(2017002,"Simonette","member","syitzhakovg@vimeo.com",8727188159,8.4);
insert into Student_Council values(2018004,"Michale","member","mwattingh@sciencedaily.com",2771934337,7.8);
insert into Student_Council values(2019001,"Francesco","member","fbarhami@imgur.com",9617695499,8.8);
insert into Student_Council values(2016169,"Sherwin","member","sumplebyj@amazon.de",1043589031,7.6);

select * from Volunteers;
## new volunteer, wants to know about his point of contacts
-- SELECT Organizing_Team.name AS OT_name, Organizing_Team.roll_no AS OT_roll_no, Organizing_Team.event AS event, Organizing_team.contact AS OT_contact,
-- Organizing_Committee.name AS OC_name, Organizing_Committee.roll_no AS OC_roll_no, Organizing_Committee.dept AS OC_dept, Organizing_Committee.contact AS OC_contact,
-- Volunteers.name AS Volunteer_name, Volunteers.roll_no AS Volunteer_roll_no
-- FROM Volunteers
-- LEFT JOIN Organizing_Committee
-- 	ON Volunteers.respective_OC=Organizing_Committee.roll_no
-- LEFT JOIN Organizing_Team
-- 	ON Volunteers.respective_OT=Organizing_Team.roll_no
-- WHERE Volunteers.roll_no=2017003;
-- ## volunteer  wants to contact other OT/OC of his/her event
-- SELECT Organizing_Team.name AS OT_name, Organizing_Team.roll_no AS OT_roll_no, Organizing_Team.event AS event, Organizing_team.contact AS OT_contact,
-- Organizing_Committee.name AS OC_name, Organizing_Committee.roll_no AS OC_roll_no, Organizing_Committee.dept AS OC_dept, Organizing_Committee.contact AS OC_contact
-- FROM Organizing_Team 
-- LEFT JOIN Organizing_Committee 
-- 	ON Organizing_Team.respective_OC=Organizing_Committee.roll_no 
-- WHERE Organizing_Team.event=(select event from (select Organizing_Team.name AS OT_name, Organizing_Team.roll_no AS OT_roll_no, Organizing_Team.event AS event, 
-- 												Organizing_team.contact AS OT_contact, Volunteers.name AS Volunteer_name, Volunteers.roll_no AS Volunteer_roll_no 
--                                                 FROM Volunteers 
--                                                 LEFT JOIN Organizing_Team
-- 													ON Volunteers.respective_OT=Organizing_Team.roll_no) AS final
-- 												WHERE Volunteer_name="Claudius Sandaver")
-- ORDER BY OT_roll_no desc limit 3;
-- select * from Volunteers,Organizing_Committee where Volunteers.roll_no=2017003 and Volunteers.respective_OC=Organizing_Committee.roll_no;
-- SELECT * FROM judges 
-- WHERE event=(SELECT EVENT FROM Volunteers,Organizing_Team 
-- 			WHERE Volunteers.respective_OT=Organizing_Team.roll_no AND Volunteers.roll_no=2017003);
-- SELECT id,name,status FROM participants 
-- WHERE event=(SELECT EVENT FROM Volunteers,Organizing_Team 
--             WHERE Volunteers.respective_OT=Organizing_Team.roll_no AND Volunteers.roll_no=2017003)
--             ORDER BY id DESC;

-- select * from Volunteers,Organizing_Team where Volunteers.respective_OT=Organizing_Team.roll_no and Volunteers.respective_OT=2019281;
-- select * from volunteers;
-- SELECT Volunteers.name AS Volunteer_name, Volunteers.roll_no AS Volunteer_roll_no,
-- Organizing_Team.name AS OT_name, Organizing_Team.roll_no AS OT_roll_no, Organizing_Team.event AS event, Organizing_team.contact AS OT_contact,
-- Organizing_Committee.name AS OC_name, Organizing_Committee.roll_no AS OC_roll_no, Organizing_Committee.dept AS OC_dept, Organizing_Committee.contact AS OC_contact
-- FROM Organizing_Team,Organizing_Committee,Volunteers WHERE Volunteers.respective_OT=Organizing_Team.roll_no AND Organizing_Team.respective_OC=Organizing_Committee.roll_no
-- AND event=(SELECT event FROM participants GROUP BY event ORDER BY count(*) DESC LIMIT 1);
-- SELECT college,count(*) FROM Participants WHERE event="street dance" GROUP BY college;
-- Select distinct S.name,S.status,S.mode_of_spons,E.event,E.dept
-- From Sponsors S, Organizing_Team E
-- Where S.point_of_contact=E.roll_no;
-- Select count(Volunteers.roll_no),Organizing_Team.event
-- From Volunteers,Organizing_Team
-- Where Volunteers.respective_OT=Organizing_Team.roll_no
-- Group By Organizing_Team.event;
-- Select distinct R.* ,E.name
-- From Organizing_Team O,Events E,Requirements R
-- Where O.event=E.name AND LOCATE(E.name,R.events) AND R.available>0;
-- Select sum(J.fee),E.dept
-- From Events E,Judges J
-- Where J.event=E.name
-- Group By E.dept;


-- SELECT name, contact, email
-- FROM Organizing_Team
-- WHERE roll_no IN (SELECT point_of_contact
-- FROM sponsors
-- WHERE name = "Devpulse");
-- select * from sponsors;

-- SELECT COUNT(*) FROM Judges where event in (select name from Events where dept="Art");
-- SELECT Student_Council.name FROM Student_Council, Organizing_Committee WHERE Student_Council.roll_no=Organizing_Committee.roll_no;
-- SELECT *
-- 	FROM ORGANISING_COMMITTEE
-- 	WHERE CGPA<7;

-- SELECT *
-- FROM Organizing_Committee
-- WHERE CGPA<7;
