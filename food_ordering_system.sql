-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2022 at 06:36 PM
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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Gender` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES
(1, 'Wael', 'w@gmail.com', '01010101010', 'Rehab', 'wael', 'w1234', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE `coupon` (
  `Coupon_ID` int(11) NOT NULL,
  `Coupon_code` int(11) NOT NULL,
  `Coupon_desc` varchar(100) DEFAULT NULL,
  `Expiry_date` varchar(15) NOT NULL,
  `discountVal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coupon`
--

INSERT INTO `coupon` (`Coupon_ID`, `Coupon_code`, `Coupon_desc`, `Expiry_date`, `discountVal`) VALUES
(1, 1515, 'Eid discount', '10/5/2022', 10);

-- --------------------------------------------------------

--
-- Table structure for table `couponnotifications`
--

CREATE TABLE `couponnotifications` (
  `Notif_ID` int(11) NOT NULL,
  `msg` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `couponnotifications`
--

INSERT INTO `couponnotifications` (`Notif_ID`, `msg`) VALUES
(1, 'Eid discount.\r\nUse promo code: 1515 \r\nfor 10LE discount on your next order.');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Gender` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES
(1, 'Mai', 'mai@gmail.com', '01010101010', 'Nasr City', 'Mai', 'm1234', 'F'),
(2, 'Youssef', 'y@gmail.com', '01111111111', 'Sheraton', 'youssef', 'y1234', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_ID` int(11) NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Order_ID` int(11) DEFAULT NULL,
  `Feedback_Date` varchar(15) DEFAULT NULL,
  `Feedback_Type` varchar(15) NOT NULL,
  `Feedback_Desc` varchar(30) NOT NULL,
  `Feedback_State` varchar(100) NOT NULL DEFAULT 'Pending',
  `Rate` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`Feedback_ID`, `Customer_ID`, `Order_ID`, `Feedback_Date`, `Feedback_Type`, `Feedback_Desc`, `Feedback_State`, `Rate`) VALUES
(1, 1, 1, '4/5/2022', 'Complaint', 'Didn\'t receive my order', 'Pending', 0),
(2, 2, 2, '4/5/2022', 'Rating', 'Perfect', 'Pending', 5);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Gender` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`ID`, `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES
(203398, 'Maiada', 'm@gmail.com', '01010101010', 'Rehab', 'manager', 'm1234', 'F');

-- --------------------------------------------------------

--
-- Table structure for table `menu_item`
--

CREATE TABLE `menu_item` (
  `MenuItem_ID` int(11) NOT NULL,
  `Rest_ID` int(11) NOT NULL,
  `Item_Name` varchar(20) NOT NULL,
  `Item_Desc` varchar(30) NOT NULL,
  `Item_Categ` varchar(15) NOT NULL,
  `Item_Price` double NOT NULL,
  `Item_Avail` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu_item`
--

INSERT INTO `menu_item` (`MenuItem_ID`, `Rest_ID`, `Item_Name`, `Item_Desc`, `Item_Categ`, `Item_Price`, `Item_Avail`) VALUES
(1, 1, 'Cheeseburger', 'with mayo', 'Sandwiches', 65, 1),
(2, 2, 'Foul', 'Dish', 'Oriental', 30, 1);

-- --------------------------------------------------------

--
-- Table structure for table `newrestnotif`
--

CREATE TABLE `newrestnotif` (
  `Notif_ID` int(11) NOT NULL,
  `msg` varchar(300) NOT NULL,
  `Cust_ID` int(11) NOT NULL,
  `Rest_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `newrestnotif`
--

INSERT INTO `newrestnotif` (`Notif_ID`, `msg`, `Cust_ID`, `Rest_ID`) VALUES
(1, 'We want to notify you that Tabali restaurant is now available on our application!\nLocated at Rehab city.\nThe restaurant is known for its Oriental Sandwiches.\nBe the first to try it out and rate!', 1, 2),
(2, 'We want to notify you that Tabali restaurant is now available on our application!\\nLocated at Rehab city.\\nThe restaurant is known for its Oriental Sandwiches.\\nBe the first to try it out and rate!', 2, 2),
(3, 'We want to notify you that McDonald\'s restaurant is now available on our application!\r\nLocated at Rehab city.\r\nThe restaurant is known for its Burger.\r\nBe the first to try it out and rate!', 1, 1),
(4, 'We want to notify you that McDonald\'s restaurant is now available on our application!\r\nLocated at Rehab city.\r\nThe restaurant is known for its Burger.\r\nBe the first to try it out and rate!', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Order_ID` int(11) NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Coupon_ID` int(11) DEFAULT NULL,
  `Rest_ID` int(11) NOT NULL,
  `Order_Date` varchar(15) DEFAULT NULL,
  `Order_Price` double DEFAULT NULL,
  `Order_PayMethod` varchar(15) DEFAULT NULL,
  `Order_status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_ID`, `Customer_ID`, `Coupon_ID`, `Rest_ID`, `Order_Date`, `Order_Price`, `Order_PayMethod`, `Order_status`) VALUES
(1, 1, NULL, 1, '4/5/2022', 65, 'Cash', 'Delivered'),
(2, 2, NULL, 1, '6/5/2022', 30, 'Cash', 'Delivered');

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
(1, 1, 1, 1, 65),
(2, 2, 2, 1, 30);

-- --------------------------------------------------------

--
-- Table structure for table `premiumcust_coupon`
--

CREATE TABLE `premiumcust_coupon` (
  `Coupon_ID` int(11) NOT NULL,
  `Premium_Cust_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `premiumcust_coupon`
--

INSERT INTO `premiumcust_coupon` (`Coupon_ID`, `Premium_Cust_ID`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `premium_customer`
--

CREATE TABLE `premium_customer` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Gender` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `premium_customer`
--

INSERT INTO `premium_customer` (`ID`, `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES
(1, 'Mai', 'mai@gmail.com', '01010101010', 'Nasr City', 'mai', 'm1234', 'F');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `Rest_ID` int(11) NOT NULL,
  `Rest_Loc` varchar(30) NOT NULL,
  `Rest_Categ` varchar(30) NOT NULL,
  `Rest_Name` varchar(20) NOT NULL,
  `Rest_Open` tinyint(4) DEFAULT NULL,
  `Rest_Rating` double DEFAULT 0,
  `RestAdmin_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`Rest_ID`, `Rest_Loc`, `Rest_Categ`, `Rest_Name`, `Rest_Open`, `Rest_Rating`, `RestAdmin_ID`) VALUES
(1, 'Rehab', 'Burger', 'McDonald\'s', 1, 0, 1),
(2, 'Rehab', 'Oriental Sandwiches', 'Tabali', 1, 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `rest_admin`
--

CREATE TABLE `rest_admin` (
  `ID` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Phone` varchar(11) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Gender` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rest_admin`
--

INSERT INTO `rest_admin` (`ID`, `Name`, `Email`, `Phone`, `Address`, `Username`, `Password`, `Gender`) VALUES
(1, 'Ahmed', 'a@gmail.com', '01010101010', 'Nasr City', 'ahmed', 'a1234', 'M'),
(2, 'Hagrass', 'h@gmail.com', '01010101010', 'Nasr City', 'hagrass', 'h1234', 'M');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`Coupon_ID`);

--
-- Indexes for table `couponnotifications`
--
ALTER TABLE `couponnotifications`
  ADD PRIMARY KEY (`Notif_ID`);

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
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `menu_item`
--
ALTER TABLE `menu_item`
  ADD PRIMARY KEY (`MenuItem_ID`),
  ADD UNIQUE KEY `MenuItem_ID` (`MenuItem_ID`),
  ADD KEY `FK_Rest_MenuItem` (`Rest_ID`);

--
-- Indexes for table `newrestnotif`
--
ALTER TABLE `newrestnotif`
  ADD PRIMARY KEY (`Notif_ID`),
  ADD KEY `FK_Notif_Rest` (`Rest_ID`),
  ADD KEY `FK_Notif_Cust` (`Cust_ID`);

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
  ADD KEY `FK_RestAdmin_Rest` (`RestAdmin_ID`);

--
-- Indexes for table `rest_admin`
--
ALTER TABLE `rest_admin`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `coupon`
--
ALTER TABLE `coupon`
  MODIFY `Coupon_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `couponnotifications`
--
ALTER TABLE `couponnotifications`
  MODIFY `Notif_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `Feedback_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203399;

--
-- AUTO_INCREMENT for table `menu_item`
--
ALTER TABLE `menu_item`
  MODIFY `MenuItem_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `newrestnotif`
--
ALTER TABLE `newrestnotif`
  MODIFY `Notif_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order_item`
--
ALTER TABLE `order_item`
  MODIFY `OrderItem_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `premium_customer`
--
ALTER TABLE `premium_customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `Rest_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rest_admin`
--
ALTER TABLE `rest_admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

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
  ADD CONSTRAINT `FK_Rest_MenuItem` FOREIGN KEY (`Rest_ID`) REFERENCES `restaurant` (`Rest_ID`);

--
-- Constraints for table `newrestnotif`
--
ALTER TABLE `newrestnotif`
  ADD CONSTRAINT `FK_Notif_Cust` FOREIGN KEY (`Cust_ID`) REFERENCES `customer` (`ID`);

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
  ADD CONSTRAINT `FK_Person_PremiumCust` FOREIGN KEY (`Premium_Cust_ID`) REFERENCES `premium_customer` (`ID`);

--
-- Constraints for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `FK_RestAdmin_Rest` FOREIGN KEY (`RestAdmin_ID`) REFERENCES `rest_admin` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
