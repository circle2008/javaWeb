-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-05-29 10:09:28
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `javaweb`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_student`
--

CREATE TABLE IF NOT EXISTS `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuNo` varchar(20) NOT NULL COMMENT '学号',
  `stuName` varchar(10) NOT NULL COMMENT '姓名',
  `sex` varchar(5) NOT NULL COMMENT '性别',
  `email` varchar(20) NOT NULL COMMENT '邮箱',
  `stuDesc` varchar(1000) NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- 转存表中的数据 `t_student`
--

INSERT INTO `t_student` (`id`, `stuNo`, `stuName`, `sex`, `email`, `stuDesc`) VALUES
(1, '3424505085', '饶杰', '男', '3424505085@qq.com', '良好'),
(2, '34245117', '刘思怡', '女', '34245117@qq.com', '优秀'),
(3, '34245130', '杨翔', '男', '34245130@qq.com', '良好'),
(4, '34245098', '方周涛', '男', '34245098@qq.com', '中'),
(5, '34245111', '王应', '男', '34245111@qq.com', '良好'),
(6, '34245124', '张洁', '女', '34245124@qq.com', '优秀'),
(7, '34245105', '祝蒙', '女', '34245105', '优秀'),
(8, '34245086', '蔡振华', '男', '34245086@qq.com', '优秀'),
(9, '34245118', '张亚丽', '女', '34245118@qq.com', '优秀'),
(10, '34245131', '叶天翔', '男', '34245131@qq.com', '中'),
(11, '34245099', '唐寅', '女', '34245099@qq.com', '中'),
(12, '34245112', '何为', '男', '34245112@qq.com', '良好'),
(13, '34245125', '罗聪', '男', '34245125@qq.com', '良好'),
(14, '34245106', '汪锐', '男', '34245106@qq.com', '良好'),
(15, '34245108', '宁浩', '男', '34245108@qq.com', '中'),
(16, '34245113', '宋豪', '男', '34245113@qq.com', '优秀'),
(17, '34245127', '钱豪', '男', '34245127@qq.com', '中'),
(18, '34245128', '舒橙', '女', '34245128@qq.com', '优秀'),
(19, '34245104', '宋林豪', '男', '34245104@qq.com', '良好'),
(20, '34245137', '李容', '女', '34245137@qq.com', '优秀'),
(21, '34245150', '余进', '男', '34245150@qq.com', '优秀'),
(22, '34245170', '汪峰', '男', '34245170@qq.com', '中'),
(23, '34245164', '钱越', '男', '34245164@qq.com', '中'),
(24, '34245138', '田源', '男', '34245138@qq.com', '良好'),
(25, '34245177', '江瑶', '女', '34245177@qq.com', '优秀'),
(26, '34245139', '宋凯', '男', '34245139@qq.com', '中'),
(27, '34245146', '马胜', '女', '34245146', '优秀'),
(28, '34245147', '唐甜', '女', '34245147', '优秀'),
(29, '34245141', '谢飞', '男', '34245141@qq.com', '中'),
(30, '34245173', '王小明', '男', '34245173', '优秀'),
(31, '34245155', '宋风', '男', '34245155@qq.com', '良好'),
(32, '34245168', '李结', '男', '34245168', '中');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
