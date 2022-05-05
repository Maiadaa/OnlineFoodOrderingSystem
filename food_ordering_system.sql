-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
<<<<<<< HEAD
-- Generation Time: May 04, 2022 at 10:20 AM
=======
-- Generation Time: May 04, 2022 at 08:42 PM
>>>>>>> parent of 5fa5e76 (view notifications DONE)
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_ordering_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE `coupon` (
  `Coupon_ID` int(11) NOT NULL,
  `Coupon_code` int(11) NOT NULL,
<<<<<<< HEAD
  `Coupon_desc` varchar(30) DEFAULT NULL,
=======
  `Coupon_desc` varchar(20) DEFAULT NULL,
>>>>>>> parent of 5fa5e76 (view notifications DONE)
  `Expiry_date` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_ID` int(11) NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Order_ID` int(11) DEFAULT NULL,
  `Feedback_Date` varchar(15) DEFAULT NULL,
  `Feedback_Type` varchar(10) NOT NULL,
  `Feedback_Desc` varchar(10) NOT NULL,
  `Feedback_State` varchar(10) NOT NULL DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `Menu_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`Menu_ID`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `menu_item`
--

CREATE TABLE `menu_item` (
  `MenuItem_ID` int(11) NOT NULL,
  `Menu_ID` int(11) NOT NULL,
  `Item_Name` varchar(15) NOT NULL,
  `Item_Desc` varchar(20) NOT NULL,
  `Item_Categ` varchar(15) NOT NULL,
  `Item_Price` double NOT NULL,
  `Item_Avail` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
<<<<<<< HEAD
=======
-- Dumping data for table `menu_item`
--

INSERT INTO `menu_item` (`MenuItem_ID`, `Menu_ID`, `Item_Name`, `Item_Desc`, `Item_Categ`, `Item_Price`, `Item_Avail`) VALUES
(1, 1, 'Orange', 'Orange', 'food', 3, 10);

-- --------------------------------------------------------

--
>>>>>>> parent of 5fa5e76 (view notifications DONE)
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Order_ID` int(11) NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Coupon_ID` int(11) DEFAULT NULL,
  `Rest_ID` int(11) NOT NULL,
  `Order_Date` varchar(15) DEFAULT NULL,
  `Order_Price` double NOT NULL,
  `Order_PayMethod` varchar(10) NOT NULL,
  `Order_status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_ID`, `Customer_ID`, `Coupon_ID`, `Rest_ID`, `Order_Date`, `Order_Price`, `Order_PayMethod`, `Order_status`) VALUES
(3, 1, NULL, 1, NULL, 12.99, 'cash', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `OrderItem_ID` int(11) NOT NULL,
  `Order_ID` int(11) NOT NULL,
  `MenuItem_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Total_ItemPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`OrderItem_ID`, `Order_ID`, `MenuItem_ID`, `Quantity`, `Total_ItemPrice`) VALUES
(1, 3, 1, 3, 12.99);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Address` varchar(20) DEFAULT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Gender` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`ID`, `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES
(1, 'Seif', 'seif@gmail.com', '01019287807', 'Rehab', 'Seif', 'seif123', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `premiumcust_coupon`
--

CREATE TABLE `premiumcust_coupon` (
  `Coupon_ID` int(11) NOT NULL,
  `Premium_Cust_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `premium_customer`
--

CREATE TABLE `premium_customer` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `Rest_ID` int(11) NOT NULL,
  `Menu_ID` int(11) NOT NULL,
  `Rest_Loc` varchar(15) NOT NULL,
  `Rest_Categ` varchar(15) NOT NULL,
  `Rest_Name` varchar(15) NOT NULL,
  `Rest_Open` tinyint(4) DEFAULT NULL,
  `Rest_Rating` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`Rest_ID`, `Menu_ID`, `Rest_Loc`, `Rest_Categ`, `Rest_Name`, `Rest_Open`, `Rest_Rating`) VALUES
(1, 1, 'Rehab', 'Fastfood', 'Mac', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `rest_admin`
--

CREATE TABLE `rest_admin` (
  `ID` int(11) NOT NULL,
  `Rest_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`Coupon_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`Feedback_ID`,`Customer_ID`),
  ADD KEY `FK_Cust_feedback` (`Customer_ID`),
  ADD KEY `FK_Order_feedback` (`Order_ID`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`Menu_ID`);

--
-- Indexes for table `menu_item`
--
ALTER TABLE `menu_item`
  ADD PRIMARY KEY (`MenuItem_ID`,`Menu_ID`),
  ADD UNIQUE KEY `MenuItem_ID` (`MenuItem_ID`),
<<<<<<< HEAD
  ADD KEY `FK_Rest_MenuItem` (`Rest_ID`);
=======
  ADD KEY `FK_Menu_MenuItem` (`Menu_ID`);
>>>>>>> parent of 5fa5e76 (view notifications DONE)

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Order_ID`,`Customer_ID`),
  ADD UNIQUE KEY `Order_ID` (`Order_ID`),
  ADD KEY `FK_Customer_Order` (`Customer_ID`),
  ADD KEY `FK_Rest_Order` (`Rest_ID`),
  ADD KEY `FK_Coupon_Order` (`Coupon_ID`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`OrderItem_ID`,`Order_ID`),
  ADD KEY `FK_MenuItem_OrderItem` (`MenuItem_ID`),
  ADD KEY `FK_Order_OrderItem` (`Order_ID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `premiumcust_coupon`
--
ALTER TABLE `premiumcust_coupon`
  ADD PRIMARY KEY (`Coupon_ID`,`Premium_Cust_ID`),
  ADD KEY `FK_Person_PremiumCust` (`Premium_Cust_ID`);

--
-- Indexes for table `premium_customer`
--
ALTER TABLE `premium_customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`Rest_ID`),
  ADD KEY `FK_Menu_Rest` (`Menu_ID`);

--
-- Indexes for table `rest_admin`
--
ALTER TABLE `rest_admin`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Rest_RestAdmin` (`Rest_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `coupon`
--
ALTER TABLE `coupon`
  MODIFY `Coupon_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `Menu_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `menu_item`
--
ALTER TABLE `menu_item`
<<<<<<< HEAD
  MODIFY `MenuItem_ID` int(11) NOT NULL AUTO_INCREMENT;
=======
  MODIFY `MenuItem_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
>>>>>>> parent of 5fa5e76 (view notifications DONE)

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order_item`
--
ALTER TABLE `order_item`
  MODIFY `OrderItem_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `Rest_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_Person_Cust` FOREIGN KEY (`ID`) REFERENCES `person` (`ID`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `FK_Cust_feedback` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `FK_Order_feedback` FOREIGN KEY (`Order_ID`) REFERENCES `order` (`Order_ID`);

--
-- Constraints for table `menu_item`
--
ALTER TABLE `menu_item`
<<<<<<< HEAD
  ADD CONSTRAINT `FK_Rest_MenuItem` FOREIGN KEY (`Rest_ID`) REFERENCES `restaurant` (`Rest_ID`);
=======
  ADD CONSTRAINT `FK_Menu_MenuItem` FOREIGN KEY (`Menu_ID`) REFERENCES `menu` (`Menu_ID`);
>>>>>>> parent of 5fa5e76 (view notifications DONE)

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FK_Coupon_Order` FOREIGN KEY (`Coupon_ID`) REFERENCES `coupon` (`Coupon_ID`),
  ADD CONSTRAINT `FK_Customer_Order` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `FK_Rest_Order` FOREIGN KEY (`Rest_ID`) REFERENCES `restaurant` (`Rest_ID`);

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `FK_MenuItem_OrderItem` FOREIGN KEY (`MenuItem_ID`) REFERENCES `menu_item` (`MenuItem_ID`),
  ADD CONSTRAINT `FK_Order_OrderItem` FOREIGN KEY (`Order_ID`) REFERENCES `order` (`Order_ID`);

--
-- Constraints for table `premiumcust_coupon`
--
ALTER TABLE `premiumcust_coupon`
  ADD CONSTRAINT `FK_Coupon_PremiumCust` FOREIGN KEY (`Coupon_ID`) REFERENCES `coupon` (`Coupon_ID`),
  ADD CONSTRAINT `FK_Person_PremiumCust` FOREIGN KEY (`Premium_Cust_ID`) REFERENCES `person` (`ID`);

--
-- Constraints for table `premium_customer`
--
ALTER TABLE `premium_customer`
  ADD CONSTRAINT `FK_Customer_Premium` FOREIGN KEY (`ID`) REFERENCES `customer` (`ID`);

--
-- Constraints for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `FK_Menu_Rest` FOREIGN KEY (`Menu_ID`) REFERENCES `menu` (`Menu_ID`);

--
-- Constraints for table `rest_admin`
--
ALTER TABLE `rest_admin`
  ADD CONSTRAINT `FK_Person_RestAdmin` FOREIGN KEY (`ID`) REFERENCES `person` (`ID`),
  ADD CONSTRAINT `FK_Rest_RestAdmin` FOREIGN KEY (`Rest_ID`) REFERENCES `restaurant` (`Rest_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
