-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 26, 2018 lúc 06:45 AM
-- Phiên bản máy phục vụ: 10.1.35-MariaDB
-- Phiên bản PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appbanhang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) CHARACTER SET utf8 NOT NULL,
  `hinhanhsanpham` varchar(200) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhsanpham`) VALUES
(1, 'Điện thoại', 'https://vcdn.tikicdn.com/cache/550x550/ts/product/65/af/4a/3c7d7d8f9e1d4e62c14523300b1e2601.jpg'),
(2, 'Laptop', 'https://vcdn.tikicdn.com/cache/550x550/ts/product/14/5c/2c/4d8e37730f504e9033482c66053784b2.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) CHARACTER SET utf8 NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` mediumtext CHARACTER SET utf8mb4 NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Điện Thoại Iphone 7 plus 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/43/ee/96/d2f39dc86c60291d0376c3e62b258b9d.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(2, 'Điện Thoại Iphone 8 plus 256GB', 30000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/c6/5a/0c/41baee987e30532fe14c5176e50b275c.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(3, 'Điện Thoại Iphone 3 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/97/7d/7d/6d19554446154285118b20a4e5dd8557.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(4, 'Điện Thoại Iphone 6s gold 120gd', 7000000, 'https://vcdn.tikicdn.com/cache/w1200/ts/product/a1/7f/84/b6b4d9f9c19642795ff73969f8ff485d.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(5, 'Điện Thoại Iphone X 256GB', 17000000, 'https://vcdn.tikicdn.com/cache/w1200/ts/product/b5/15/46/4bb9d22171fd479473598fe4295759dc.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(6, 'LapTop del 5559', 17000000, 'https://vcdn.tikicdn.com/cache/w1200/ts/product/5f/b8/c7/e542b46e66817bc00256aa1930b9ab9c.png', 'Mặt trên vẫn sử dụng hoạ tiết đồng tâm nhưng được phủ bằng lớp kính giống như trên smartphone, phản chiếu ánh sáng đẹp và lạ mắt. Giống như những sản phẩm khác có vỏ bằng kính, bên cạnh sự đẹp mắt thì bạn sẽ phải chấp nhận bề mặt rất dễ bám vân tay, có thể phải lau thường xuyên. Hiện tại Asus mới đem về Việt Nam phiên bản duy nhất có màu Royal Blue (Xanh hoàng gia) và mặt kính bóng.', 2),
(7, 'Laptop Asus UX410UQ-GV066 Core i5-7200U', 16699, 'https://vcdn.tikicdn.com/cache/w1200/media/catalog/product/a/s/asus-ux410uq-gv066-2.u504.d20170118.t141320.89929.jpg', 'Mặt trên vẫn sử dụng hoạ tiết đồng tâm nhưng được phủ bằng lớp kính giống như trên smartphone, phản chiếu ánh sáng đẹp và lạ mắt. Giống như những sản phẩm khác có vỏ bằng kính, bên cạnh sự đẹp mắt thì bạn sẽ phải chấp nhận bề mặt rất dễ bám vân tay, có thể phải lau thường xuyên. Hiện tại Asus mới đem về Việt Nam phiên bản duy nhất có màu Royal Blue (Xanh hoàng gia) và mặt kính bóng.', 2),
(8, 'Laptop HP ProBook 450 G4 Z6T22PA Core i5-7200U', 13, 'https://vcdn.tikicdn.com/cache/w1200/media/catalog/product/z/6/z6t22pa-1.u2751.d20170222.t171117.948693.jpg', 'Mặt trên vẫn sử dụng hoạ tiết đồng tâm nhưng được phủ bằng lớp kính giống như trên smartphone, phản chiếu ánh sáng đẹp và lạ mắt. Giống như những sản phẩm khác có vỏ bằng kính, bên cạnh sự đẹp mắt thì bạn sẽ phải chấp nhận bề mặt rất dễ bám vân tay, có thể phải lau thường xuyên. Hiện tại Asus mới đem về Việt Nam phiên bản duy nhất có màu Royal Blue (Xanh hoàng gia) và mặt kính bóng.', 2),
(9, 'Điện Thoại Iphone 34 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/3b/d6/c5/4d48c1ef3cfa93716d31119db29d90ed.jpgg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(10, 'Điện Thoại Iphone 4 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/14/b5/98/14b1627f921d07810833153c6acd93c6.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(11, 'Điện Thoại Iphone 6 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/90/6f/10/61e10c5b20b7631dee5a2bf373751884.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(12, 'Điện Thoại Iphone 5 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/18/5b/e4/d477bf93d12ec906e33265f3474ff9ff.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(13, 'Điện Thoại Iphone 345 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/59/54/72/abc64507e2035e6f51b71d7b061bdba5.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(14, 'Điện Thoại Iphone 47 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/media/catalog/product/1/-/1-u2769-d20170609-t114956-258512.u5564.d20170817.t091533.467264.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(15, 'Điện Thoại Iphone 65 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/38/41/a2/1e94630e62ba857a59c26425c30b374c.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(16, 'Điện Thoại Iphone 56 256GB', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/38/41/a2/1e94630e62ba857a59c26425c30b374c.jpgg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 1),
(17, 'LapTop del 55599', 17000000, 'https://vcdn.tikicdn.com/cache/w1200/ts/product/b5/15/46/4bb9d22171fd479473598fe4295759dc.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 2),
(18, 'LapTop del 5559', 17000000, 'https://vcdn.tikicdn.com/cache/w1200/ts/product/5f/b8/c7/e542b46e66817bc00256aa1930b9ab9c.png', 'Mặt trên vẫn sử dụng hoạ tiết đồng tâm nhưng được phủ bằng lớp kính giống như trên smartphone, phản chiếu ánh sáng đẹp và lạ mắt. Giống như những sản phẩm khác có vỏ bằng kính, bên cạnh sự đẹp mắt thì bạn sẽ phải chấp nhận bề mặt rất dễ bám vân tay, có thể phải lau thường xuyên. Hiện tại Asus mới đem về Việt Nam phiên bản duy nhất có màu Royal Blue (Xanh hoàng gia) và mặt kính bóng.', 2),
(19, 'Laptop Asus UX410UQ0-GV066 Core i7-7200U', 16699, 'https://vcdn.tikicdn.com/cache/w1200/media/catalog/product/a/s/asus-ux410uq-gv066-2.u504.d20170118.t141320.89929.jpg', 'Mặt trên vẫn sử dụng hoạ tiết đồng tâm nhưng được phủ bằng lớp kính giống như trên smartphone, phản chiếu ánh sáng đẹp và lạ mắt. Giống như những sản phẩm khác có vỏ bằng kính, bên cạnh sự đẹp mắt thì bạn sẽ phải chấp nhận bề mặt rất dễ bám vân tay, có thể phải lau thường xuyên. Hiện tại Asus mới đem về Việt Nam phiên bản duy nhất có màu Royal Blue (Xanh hoàng gia) và mặt kính bóng.', 2),
(20, 'Laptop HP ProBook 450 G4 Z6T22PA Core i5-7200U', 13, 'https://vcdn.tikicdn.com/cache/w1200/media/catalog/product/z/6/z6t22pa-1.u2751.d20170222.t171117.948693.jpg', 'Mặt trên vẫn sử dụng hoạ tiết đồng tâm nhưng được phủ bằng lớp kính giống như trên smartphone, phản chiếu ánh sáng đẹp và lạ mắt. Giống như những sản phẩm khác có vỏ bằng kính, bên cạnh sự đẹp mắt thì bạn sẽ phải chấp nhận bề mặt rất dễ bám vân tay, có thể phải lau thường xuyên. Hiện tại Asus mới đem về Việt Nam phiên bản duy nhất có màu Royal Blue (Xanh hoàng gia) và mặt kính bóng.', 2),
(21, 'LapTop del 5558', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/bc/fd/34/fbd29407ada77c1c0095fab6da6f0cb3.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 2),
(22, 'LapTop del 555999', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/3d/c2/5d/1048391a0912e5039bc2580f690480af.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 2),
(23, 'LapTop del 55559', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/media/catalog/product/d/e/dell-n3567a.u2751.d20170228.t171620.192910.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 2),
(24, 'LapTop del 55596', 28000000, 'https://vcdn.tikicdn.com/cache/550x550/ts/product/14/5c/2c/4d8e37730f504e9033482c66053784b2.jpg', 'Nhằm phục vụ nhu cầu tặng quà của bạn, Tiki cung cấp dịch vụ gói quà và gửi thiệp với thông điệp của riêng bạn. Đây là dịch vụ có tính phí và chỉ áp dụng cho các đơn hàng có sử dụng hình thức giao hàng 2 tiếng TikiNOW. Bạn có thể xem biểu phí', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
