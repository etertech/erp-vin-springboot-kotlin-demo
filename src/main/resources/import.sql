INSERT INTO `users` (`birthday`, `enabled`, `id`, `email`, `first_name`, `last_name`, `password`, `telephone`, `username`) VALUES ('1990-08-29', b'1', 1, 'admin@erpvin.com', 'Xudong', 'ZHAO', '$2y$10$EHF3slOBYU9fmFTSZkKj8uI8dJt9JS2g9aJuu0.pbUu1T7OZ9FDVW', '0612345678', 'admin');
INSERT INTO `users` (`birthday`, `enabled`, `id`, `email`, `first_name`, `last_name`, `password`, `telephone`, `username`) VALUES ('1990-01-01', b'1', 2, 'manager@erpvin.com', 'Mathieu', 'Dupont', '$2a$10$Jn8qPPtxNgxKM2QYU3mb5O/13RLqcc0bx7r.OFlZqfBxDxCJvip6O', '0198761234', 'manager');
INSERT INTO `users` (`birthday`, `enabled`, `id`, `email`, `first_name`, `last_name`, `password`, `telephone`, `username`) VALUES ('1990-01-01', b'1', 3, 'user@erpvin.com', 'Alexandre', 'Leroux', '$2a$10$KiwuIsQ7NGxZv9MXCz9znOkb4kkDEY221H7b.oDKkmWZ1035EIaiW', '0344333344', 'user');
INSERT INTO `roles` (`id`, `name`) VALUES (1, 'ADMIN');
INSERT INTO `roles` (`id`, `name`) VALUES (2, 'MANAGER');
INSERT INTO `roles` (`id`, `name`) VALUES (3, 'USER');
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES (2, 1);
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES (3, 1);
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES (3, 2);
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES (2, 2);
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES (3, 3);
INSERT INTO erp_vin_db.categories (id, category_name) VALUES (1, 'Vin rouge');
INSERT INTO erp_vin_db.categories (id, category_name) VALUES (2, 'Vin blanc');
INSERT INTO erp_vin_db.categories (id, category_name) VALUES (3, 'Vin rosé');
INSERT INTO erp_vin_db.categories (id, category_name) VALUES (4, 'Grands vins');
INSERT INTO erp_vin_db.categories (id, category_name) VALUES (5, 'Champagne');

INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (1, 'Ivry-sur-Seine', 'France', '94200', 'Île-de-France', '4 Avenue du Général Leclerc');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (2, 'Paris', 'France', '75016', 'Île-de-France', '50 Boulevard Suchet');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (3, 'Xi An Shi', 'Chine', '710077', 'Shan Xi Sheng', 'Feng Deng Nan Lu');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (4, 'Ivry-sur-Seine', 'France', '94200', 'Île-de-France', '280 Avenue du Général Leclerc');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (5, 'Paris', 'France', '75016', 'Île-de-France', '30 Boulevard Suchet');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (6, 'Pékin', 'Chine', '100033', 'Bei Jing Shi', '16 Tai Ping Qiao Da Jie');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (7, 'Lyon', 'France', '69003', 'Auvergne-Rhône-Alpes', '63 Place Voltaire');
INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES (8, 'Wu Han Shi', 'Chine', '430074', 'Hu Bei Sheng', '80 luo shi lu');

INSERT INTO `warehouses` (`address_id`, `id`, `name`) VALUES (1, 1, 'Entrepôt Ivry-sur-Seine');
INSERT INTO `warehouses` (`address_id`, `id`, `name`) VALUES (2, 2, 'Entrepôt Paris');
INSERT INTO `warehouses` (`address_id`, `id`, `name`) VALUES (3, 3, 'Entrepôt Xi An');
INSERT INTO `unit_product` (`id`, `name`) VALUES (1, 'Bouteille');
INSERT INTO `unit_product` (`id`, `name`) VALUES (2, 'Coffret 3 bouteilles');
INSERT INTO `unit_product` (`id`, `name`) VALUES (3, 'Coffret 6 bouteilles');
INSERT INTO `products` (`price`, `sold_quantity`, `stock`, `year`, `category_id`, `id`, `unit_id`, `warehouse_id`, `description`, `product_name`) VALUES (6.3, 1, 60, 2022, 1, 1, 1, 1, 'Composé en majorité de raisins issus de vignes de plus de quarante ans, Les Darons (les Pères en argot) porte bien son nom ! Charmeur avec son nez fruité et épicé, équilibré et puissant, il possède des nuances légèrement toastées (bien qu’élevé en fût) qui apportent un relief et une générosité des plus appréciables. Un vin solide et sûr de lui qui s’adresse à ceux qui ont suffisamment de bouteille pour apprécier les bonnes choses de la vie !', 'LES DARONS 2022 - BY JEFF CARREL');
INSERT INTO `products` (`price`, `sold_quantity`, `stock`, `year`, `category_id`, `id`, `unit_id`, `warehouse_id`, `description`, `product_name`) VALUES (7.6, 1, 50, 2019, 1, 2, 1, 1, 'Un rapport qualité/prix incroyable pour un cru 2019 sensationnel, ce Ventoux est le parfait allié pour surprendre vos amis en toute occasion !\r\nCe Ventoux à la robe d’un rouge puissant aux reflets violets ne vous laissera pas insensible. Le bouquet aromatique remarquable qui le compose avec ses notes de fruits des bois et cerises, de poivre noir et de fleurs séchées mettent parfaitement en valeur cette appellation. Un vin équilibré, puissant dont les tannins très souples qui se mêlent à une finale savoureuse et épicée!', 'VENTOUX 2019 - XAVIER VIGNON');
INSERT INTO `products` (`price`, `sold_quantity`, `stock`, `year`, `category_id`, `id`, `unit_id`, `warehouse_id`, `description`, `product_name`) VALUES (15.72, 1, 100, 2019, 1, 3, 2, 2, 'Le Château Pierron faisait partie à l\'époque d\'un petit hameau aujourd\'hui disparu. Il est caractérisé par des rendements maîtrisés, une vendange saine et une bonne maturité. D\'une couleur rouge intense aux reflets rubis, il dégage des arômes de fruits mûrs, de fruits rouges. En bouche, c\'est un vin facile à boire, sur le fruit et la fraicheur tout en ayant une belle expression de maturité. A ce prix et avec autant d\'atouts, ce Château Pierron 2019 est l\'affaire à ne PAS manquer pour vos repas du quotidien !', 'CHATEAU PIERRON 2019');
INSERT INTO `product_photos` (`id`, `product_id`, `photo_link`) VALUES (1, 1, 'https://storage.googleapis.com/erpvin/les-darons-2022-by-jeff-carrel.png');
INSERT INTO `product_photos` (`id`, `product_id`, `photo_link`) VALUES (2, 2, 'https://storage.googleapis.com/erpvin/ventoux-2019-xavier-vignon.png');
INSERT INTO `product_photos` (`id`, `product_id`, `photo_link`) VALUES (3, 3, 'https://storage.googleapis.com/erpvin/chateau-pierron-2019.png');

INSERT INTO `clients` (`added_date`, `address_id`, `id`, `company_name`, `email`, `first_name`, `last_name`, `telephone`) VALUES ('2023-09-18 22:00:19.000000', 4, 1, '', 'jean.dupont@email.com', 'Jean', 'Dupont', '0123456789');
INSERT INTO `clients` (`added_date`, `address_id`, `id`, `company_name`, `email`, `first_name`, `last_name`, `telephone`) VALUES ('2023-09-18 22:01:03.000000', 5, 2, 'Dufour Designs', 'marie.dufour@email.com', 'Marie', 'Dufour', '0198765432');
INSERT INTO `clients` (`added_date`, `address_id`, `id`, `company_name`, `email`, `first_name`, `last_name`, `telephone`) VALUES ('2023-09-18 22:02:02.000000', 6, 3, '', 'wang.wei@email.cn', 'Wei', 'Wang', '8613911111111');
INSERT INTO `clients` (`added_date`, `address_id`, `id`, `company_name`, `email`, `first_name`, `last_name`, `telephone`) VALUES ('2023-09-18 22:02:56.000000', 7, 4, 'Moreau Tech SARL', 'francois.moreau@email.com', 'François', 'Moreau', '0147852369');
INSERT INTO `clients` (`added_date`, `address_id`, `id`, `company_name`, `email`, `first_name`, `last_name`, `telephone`) VALUES ('2023-09-18 22:03:37.000000', 8, 5, '', 'li.tingting@email.cn', 'Tingting', 'Li', '8615922222222');


