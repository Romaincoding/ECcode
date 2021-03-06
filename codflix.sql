-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 25, 2020 at 05:54 PM
-- Server version: 5.7.26
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `codflix`
--

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
                         `id` int(11) NOT NULL,
                         `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Action'),
(2, 'Horreur'),
(3, 'Science-Fiction'),
(4, 'Drame'),
(5, 'Western'),
(6, 'Romance'),
(7, 'Policier');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
                           `id` int(11) NOT NULL,
                           `user_id` int(11) NOT NULL,
                           `media_id` int(11) NOT NULL,
                           `start_date` datetime NOT NULL,
                           `finish_date` datetime DEFAULT NULL,
                           `watch_duration` int(11) NOT NULL DEFAULT '0' COMMENT 'in seconds'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
                         `id` int(11) NOT NULL,
                         `genre_id` int(11) NOT NULL,
                         `title` varchar(100) NOT NULL,
                         `type` varchar(20) NOT NULL,
                         `status` varchar(20) NOT NULL,
                         `release_date` date NOT NULL,
                         `summary` longtext NOT NULL,
                         `trailer_url` varchar(100) NOT NULL,
                         `imageUrl` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `media`
--

INSERT INTO `media` (`id`, `genre_id`, `title`, `type`, `status`, `release_date`, `summary`, `trailer_url`, `imageUrl`) VALUES
(1, 1, 'triple x', 'movie', 'released', '2002-09-10', 'bad movie with bad actor', 'https://www.youtube.com/embed/8W9zEtqLXJM', 'https://resizeimage.net/mypic/PX1cb2MhIQMqWtST/RhtX9/triple-x.jpg'),
(2, 3, 'Alien', 'movie', 'released', '1979-12-09', 'Durant le voyage de retour d\'un immense cargo spatial en mission commerciale de routine, ses passagers, cinq hommes et deux femmes plongés en hibernation, sont tirés de leur léthargie dix mois plus tôt que prévu par Mother, l\'ordinateur de bord. Ce dernier a en effet capté dans le silence interplanétaire des signaux sonores, et suivant une certaine clause du contrat de navigation, les astronautes sont chargés de prospecter tout indice de vie dans l\'espace.', 'https://www.youtube.com/embed/DGAHtWV7Ua8', 'https://resizeimage.net/mypic/TEeEoq56U2exfOd7/S0SPY/alien.jpg'),
(3, 2, 'l\'exorciste', 'movie', 'released', '1974-11-09', 'Regan, âgée de 12 ans, souffre d\'inquiétants troubles du comportement. Après de nombreux examens médicaux, sa mère Chris MacNeil sollicite l\'aide d\'un jeune prête psychiatre, le Père Karras qui lui apprend que la jeune fille est possédée par le diable. Avec l\'aide de son confrère le père Merrin, il va se lancer dans des séances d\'exorcisme d\'une incroyable intensité...', 'https://www.youtube.com/embed/3Z_36I2Q-_U', 'https://resizeimage.net/mypic/qMxN6QTpZZKOPXFE/dPlun/l-exorciste.jpg'),
(4, 1, 'the leftovers', 'serie', 'released', '2014-01-04', 'Trois ans après la disparition soudaine de deux pour cent de la population mondiale, les résidents de Mapleton, dans l\'État de New York, s\'apprêtent à souligner la disparition de ces êtres chers. À l\'approche des cérémonies de commémoration, le shérif Kevin Garvey est en état d\'alerte maximale -- des affrontements dangereux se préparent entre la population et un groupuscule aux revendications mystérieuses, comparables à une secte. Cette émission suit en particulier les membres de la famille Garvey qui chacun à leur façon peinent à se remettre de cet étrange phénomène.', 'https://www.youtube.com/embed/V3XojDp2eWA', 'https://resizeimage.net/mypic/yaVt09408DdMDBoE/Ro8di/leftaffiche.jpg'),
(5, 7, 'The shield', 'serie', 'released', '2005-02-09', 'Pour rétablir l\'ordre dans les secteurs les plus dangereux de Los Angeles, une brigade de police en arrive à mettre en oeuvre des méthodes plutôt expéditives et inhabituelles.', 'https://www.youtube.com/embed/8YiqPv3Ha68', 'https://resizeimage.net/mypic/hxKh2XElMWTnhtMt/lrbwG/shi.jpg'),
(6, 7, 'the wire', 'serie', 'released', '2006-11-09', 'Un agent aux homicides et un détective aux narcotiques collaborent afin de démanteler une opération. La criminalité dans la ville de Baltimore, à travers la vision de ceux qui la vivent au quotidien.', 'https://www.youtube.com/embed/9qK-VGjMr8g', 'https://resizeimage.net/mypic/9m1uMdEplIveIQ0T/IkjXc/sur-ecoute-affiche_287341_4832.jpg'),
(7, 4, 'Amours chiennes', 'movie', 'released', '2000-11-01', 'Mexico. Un tragique accident de voiture met en relation trois histoires radicalement différentes : Octavio, un adolescent qui a décidé de s\'enfuir avec la femme de son frère. Daniel, un quadragénaire qui quitte sa femme et ses enfants pour aller vivre avec un top model. El Chivo, un ex-guerillero communiste devenu tueur à gages, qui n\'attend plus rien de la vie.', 'https://www.youtube.com/embed/xToY4ij9gxQ', 'https://resizeimage.net/mypic/doPQadTzciSIGc8A/M3jKL/amours-chiennes.jpg'),
(8, 4, 'Breaking bad', 'serie', 'released', '2008-09-10', 'Walter White, 50 ans, est professeur de chimie dans un lycée du Nouveau-Mexique. Pour réunir de l\'argent afin de subvenir aux besoins de sa famille, Walter met ses connaissances en chimie à profit pour fabriquer et vendre du crystal meth\r\n', 'https://www.youtube.com/embed/ceqOTZnhgY8\r\n', 'https://resizeimage.net/mypic/cIaOE7eMXgcSKc8n/HFMUT/breaking-bad-affiche_401790_14.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `serie`
--

CREATE TABLE `serie` (
                         `id` int(11) NOT NULL,
                         `serie_id` int(11) NOT NULL,
                         `saison` int(11) NOT NULL,
                         `episode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `serie`
--

INSERT INTO `serie` (`id`, `serie_id`, `saison`, `episode`) VALUES
(1, 6, 5, 60),
(2, 5, 7, 60),
(3, 4, 3, 30);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
                        `id` int(11) NOT NULL,
                        `email` varchar(254) NOT NULL,
                        `password` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`) VALUES
(11, 'jeanaimarre@gmail.com', '400d080a8f8dca39e166e3af212462adf1f0c9c2fec98cd6faa6da44dc329d8b'),
(12, 'jeanpeuxplus@gmail.com', '4064e6a9a434b058fcae69eb01a5374e91705380e2f4b9fd940120c6696fc050'),
(13, 'tryhard@gmail.com', 'fd7d0e018c08a54cdedfb10cf776da13c15529e93c4a1414dfc260b674315e35'),
(14, 'merciqui@gmail.com', '37755b1afe16a4973d4d2208c4a7dea45e2e5772015dc3d34e04eeed77f58591'),
(15, 'test@gmail.com', '16f5551f701388c607a9a934dd4d9bf17e0390b84de0188b3952b2746c0d9a2f');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
    ADD PRIMARY KEY (`id`),
    ADD KEY `history_user_id_fk_media_id` (`user_id`),
    ADD KEY `history_media_id_fk_media_id` (`media_id`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
    ADD PRIMARY KEY (`id`),
    ADD KEY `media_genre_id_fk_genre_id` (`genre_id`) USING BTREE;

--
-- Indexes for table `serie`
--
ALTER TABLE `serie`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK_media_id` (`serie_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `serie`
--
ALTER TABLE `serie`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
    ADD CONSTRAINT `history_media_id_fk_media_id` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `history_user_id_fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `media`
--
ALTER TABLE `media`
    ADD CONSTRAINT `media_genre_id_b1257088_fk_genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`);

--
-- Constraints for table `serie`
--
ALTER TABLE `serie`
    ADD CONSTRAINT `FK_media_id` FOREIGN KEY (`serie_id`) REFERENCES `media` (`id`);
