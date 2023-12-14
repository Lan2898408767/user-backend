/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 101.200.88.100:3306
 Source Schema         : usercenter

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 14/12/2023 16:51:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '⽤户昵称',
  `userAccount` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `avatarUrl` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '⽤户头像',
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `userPassword` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `userStatus` int(11) NULL DEFAULT 0 COMMENT '状态 0-正常',
  `phone` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `createTime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NULL DEFAULT 0 COMMENT '0-未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员', 'admin', 'data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAMAAzAMBIgACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAABgcBBAUDAv/EADoQAAEDAwIDBQYDBgcAAAAAAAEAAgMEBREGIRIxQQcTIlFhFBVxgZGhMrHBJEJDUtHhFhcjM2Jykv/EABoBAQEBAQEBAQAAAAAAAAAAAAABAgMEBgX/xAAeEQEBAAMBAQEBAQEAAAAAAAAAAQIDETEhEhNBBf/aAAwDAQACEQMRAD8AvFERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQERYQZRadyr6e20clVVP4GMB+J9B6qubvq+53QyRW/9kpyPC8HDvmeilvG8MMs7zFaS+JZGRsL5HNaxu5JOAFTTam+Rv7yluVQ7ByfGT+a+b7qi+3C2NtlXGPE8F0jW4c7yB+eFJlK3nozw9i5oJo54xJC9r2Hk5pyF6Li6QtZs9gpqRzuJ+ON5z+8dyu0tOIiIgIiICIiAiIgIiICIiAiIgIiICIiAsLKIKr7Rro+qvjLY04jhAJx5ndcVjmtaWgYHQDouhqyAf4rqpHlrXF2Gtz+IYC0QwZIOy8u63r9//m4Yfz7/AKGoc0Yb9lrVbXTwOGTxjcEFenA78LcHP1WvVSdzEeI4dywuePe/Hu2zX+L+lk9mt2kuNlfFO8vlpXhnEeZb0/VS9Vd2d3m22K2VDrjOY3zyAgCNx2GwJOFYVuvVuuY/YauOV2MloPiHyXtnj5TKctdBFgLKrIiIgIiICIiAiIgIiICIiAiIgIiIC85po4IXyyvDY2NLnOPIAL0UR7SqowafEWXATyhh4T0wTg/RBDtW3aLU9cILLbpJJWHBmaN3jp8N+q40tNqG2Nb7Vb5uHoS3P3CtPS1tprbZ6ZtMwAyRh75MeJxPmusRkdPmF5Mt0749OvPLCfKp612rUF74RDE6GEneRw4QPgeaktv7N4w4S3Gve93lF5/EqdktaTyAHLOyx38IJBmj/wDQWf6W+RctmWXtciDStngbj2USZ594crl3XSEcTm1lmJhqYt2ji/IqWh7XjwODseRBR5a1rnOIAaDknkAszPKVi+ObpC+e9aV0U8jXVcOz8DHEOhwpCq30DJ7x1Xc6+Han4XNaBtzO35Kx+i908cb6yiIqgiIgIiICIiAiIgIiICIiAiIgKL9odvnr9OyCma50kTxLho3wOeFKFxdT3yCx2588gD5XAiGLP43f080Weo7p/WFqFjgFdUMppoY+F0bjuceXmtX/ABlW3ed0Nhtsr2DYSYJPoeWAuTp7Rs+pKmS53UGlpJH8TY4m8Jk36eQ9VZtqtVFaqVtPQQNiiHQDcnzJXGace9buaIu0pfLkA64XV8bTzYXcRHwxsvh3ZnC45dd6nJ/4/wB1P8JgLrJIz+qrqbs6r4AXW++v4ugewt+4cuHfrfrGiiMFVNU1FIGnxRv4mkevVXDgIQCMHkU/MP1UH7O66zMojS0zjFWPPFKybAc/1HopwOSiuoNH01VmqtbRTVrfE0t2DiPyK09J6smfV+5r4wxVjPC17zji9D6oepuiDkirIiIgIiICIiAiIgIiICIiAiLymmigaZJpWRsHNz3ABB9SPEbHPccNaMknoq2pRLrTVj5pHO910mcAjZzfIfE/YLv67vDItNTmgqGPfK4RcUTwSM8/1XvoG1+69PQd40iaYCV/pnkPoipHHGyJjY42hrGjAaBsAvtERBERAREQYwodr7TIucBuNCwi4QDOW83t8lMl8nmhFc2ntJgp7VHHcIJpq2M8GI+TwOpPQ9F2LFr+3XWtZSSRvpZZDiPjcCHHoPiuhQ6Rs1FcJa2Ola6V5J8YyBnngLgdpdoh9jpbhTtEE0UgbxsGNsEj7qNfKn2VlalqldPbaWV54nPiaSfPbmttVkREQEREBERAREQEREHxI4NY5x5AEkqsbfFJrq/VstVK4UMDgGtH7rd8Aep5lWZUM72GSPOONpGfiq67OpRZr1cbPWZZJK8FvFtu3P5ghGo3ndnsbbpFLS1r46Noy+M7vcc8sqdMYGMa0cgMBZGAFlErDiGgkkADzXh7VBxcPeNyUrc+yy4/lKjgk5rOWXHbVq/pG5q7UMdgtjpwA+oceGJhPM+vos6bvhuGn6a5XLuqZ0uRu4AHBIyPjhcK8Wumu/d+3B0ndnLcOx9V1ZLBBdbNDTOcYmROzFw8gMYxhSZd8by0TDn6vx73evguNJV22217GVz4TwFjuXzUL7P79daa7us9176SLDsOly4xuHqeil1l0pT2qd1QZDLOWlrXEYDcrzkD4nvY4b8jlTtk+rjq15ZWYV03XQiXwhvdg755rqMdxMDvMKKxtMsjY29dsKUxt4Y2t8hhXG9Y368cOSPpVz2j1slxu1DYqJ3jDg6Qt3wTsB8hv9FYyq+JrrJ2nl9wAfHVEmOQjlxcj9dltwiyqSEU9NFCP4bA36Be6xlZRBERAREQEREBERAREQYKiesNKm5vFxt0hhuMQBBH8THIehUtXxI7hDjnGAShEb0TfprxSTwVzOCuo3d3MMYzzwfsVJ1XfZpJ3t7vr2kEFzSXZ/F4nf3+qsRFr5e0OY5pGQRgrgVtDJC93BvGdwpCvktzzUs63r2XC/Eap6WWZ4a1hx1zspFDGIo2xtGzQvsMA5ABZwpjjxrbuuyh3WtU0UNT/uN8X8zditlFpyls+xqU1BFTHiZku8ytsJhZU5wuVyvawFDO0mjZ7vgufAXPpZBktODwk/1wpotC90LbhaaqkcARJGQM+apPWLHXx3K109XEciRoz6Hqugq/7Jq1xpK62yc6aQOafQ7EfUfdWAhREREEREBERAREQEREBa9fM2CjnlduGMJP0WwuBrmr9i0vXSb5czgHz2Qjgdl0OfelX3IjEr2AHzxxEj7hT5Rbs4hMelaZ5O8rnPP1/spSi30RERBERAREQEREBDyREFb6Jayi1zdaOMFocHnc8/ED+pVkKsrVIG9rVQGnZ/eDb/plWaouQiIqgiIgIiICIiAiIgLg63pzU6YuDB0j4vou8vOVjZGOY8Za4YIPUII12dVEUmmoIIZGuNOSxwHMdQpM97Y2F73BrRuSVXtRpa+2SvmqdM1AEM3ONxG3kCDsfivsaZ1HeHR++rl3cYB4mtIJOeew2RanlPUw1LOOnmZKzOMsOQvZVnW0Vx0NXmstbX1NA/eVrhnA65xy+K2T2mxSxtbS22Z87hs0nbKHE9qamKlhdNUSNjjaN3OOAFB7h2n26nqDHTU0k0QdgykhoPwytKKz37WEjZ7y51HSA5EWMbeQb+pUztem7Va6U09NSRlrhh7pBxOf8Sh4+7Bf6G+05loZMloHGw7Ob8l1Aq1vFkrtJ3b3vYozJSbmSLo0HmCPL16Lfd2lUTKNsjqOcTuaCI8jGfihxNauqho4XT1MrYom83uOAFD/APMe2+1FvcyiAHBkPP6LgPjv2va2Mzx+yW1h9cfHf8RU8Zpu2Ms/uvuAactwST4ifPPmg6FBX09wpmVFJK2SN3UdPj5L0nqI6eF0072xxsGXOdsAq/n0fe7NI6XTdweWkn/Te7BH6Fa09m1pfiykutR3NMD4neEA/Ic0OPfQdGa/VlzvWcxhzgw45lx6fIfdWQubYrRT2W3x0lK3Zo8TsYLj1JXSUhb0REVQREQEREBERAREQEREGEwsogw5rXAhwBB6FeTKSnjOWQRNPmGAL2RBgAeSyiIPlzQRggEHmtT3Xb+87z2Kn4/5u6GVuogw1rWjAAA8gE2WUQYwmFlEBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERB//2Q==', 1, '11b6d333564fc89d68c23d9f8556fa0b', '2898408767@qq.com', 0, '17603346444', '2023-12-14 16:49:31', '2023-12-14 16:49:31', 0);
INSERT INTO `user` VALUES (2, '管理员', 'root', '+87z2Kn4/5u6GVuogw1rWjAAA8gE2WUQYwmFlEBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERB//2Q==', 1, '11b6d333564fc89d68c23d9f8556fa0b', '2898408767@qq.com', 0, '17603346444', '2023-12-14 16:50:05', '2023-12-14 16:50:28', 0);
INSERT INTO `user` VALUES (3, '普通用户', 'user', '+87z2Kn4/5u6GVuogw1rWjAAA8gE2WUQYwmFlEBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERB//2Q==', 1, '11b6d333564fc89d68c23d9f8556fa0b', '2898408767@qq.com', 0, '17603346444', '2023-12-14 16:50:48', '2023-12-14 16:50:58', 0);

SET FOREIGN_KEY_CHECKS = 1;
