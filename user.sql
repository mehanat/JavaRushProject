-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Фев 15 2016 г., 16:20
-- Версия сервера: 5.6.17
-- Версия PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `test`
--

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `isAdmin` bit(1) DEFAULT NULL,
  `createdDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=63 ;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES
(7, 'Anatoly', 26, b'1', '2016-02-25 21:00:00'),
(11, 'Serg', 5, b'0', '2016-02-14 09:53:28'),
(47, 'Ivan', 16, b'0', '2016-02-15 05:56:18'),
(48, 'Ivan', 18, b'0', '2016-02-15 05:56:18'),
(51, 'Anatoly', 19, b'1', '2016-02-15 06:24:17'),
(53, 'Anton', 23, b'0', '2016-02-15 10:44:21'),
(54, 'Dima', 20, b'0', '2016-02-15 10:44:38'),
(55, 'Anna', 21, b'0', '2016-02-15 10:44:50'),
(56, 'Izabella', 19, b'1', '2016-02-15 10:45:03'),
(58, 'Igor', 6, b'0', '2016-02-15 10:46:57'),
(59, 'Pavel', 26, b'0', '2016-02-15 10:47:05'),
(60, 'Artur', 18, b'0', '2016-02-15 10:47:21'),
(62, 'Anat', 0, b'0', '2016-02-15 15:13:06');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
