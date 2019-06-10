# Host: localhost  (Version 5.1.33-community)
# Date: 2019-06-10 14:58:12
# Generator: MySQL-Front 6.1  (Build 1.24)


#
# Structure for table "choose"
#

CREATE TABLE `choose` (
  `lessonname` varchar(11) NOT NULL DEFAULT '',
  `studentname` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "choose"
#

INSERT INTO `choose` VALUES ('java','jack'),('java','k'),('python','jack');

#
# Structure for table "lesson"
#

CREATE TABLE `lesson` (
  `lessonname` varchar(11) NOT NULL DEFAULT '',
  `time` varchar(255) DEFAULT NULL,
  `require` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `exam` varchar(255) DEFAULT NULL,
  `teachername` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lessonname`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "lesson"
#

INSERT INTO `lesson` VALUES ('java','32','k','k','k','k','k'),('python','32','n','n','n','n','n');

#
# Structure for table "student"
#

CREATE TABLE `student` (
  `username` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (123,'123','jack','19','m','computer','11603','01','123');

#
# Structure for table "teacher"
#

CREATE TABLE `teacher` (
  `username` varchar(11) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES ('111','111','n','n','n','n','n'),('456','456','k','35','m','computer','Professor');
