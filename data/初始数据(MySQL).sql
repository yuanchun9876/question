
-- ----------------------------
-- Records of education_type
-- ----------------------------
INSERT INTO education_type VALUES ('0', '无学历');
INSERT INTO education_type VALUES ('1', '三校');
INSERT INTO education_type VALUES ('2', '大专');
INSERT INTO education_type VALUES ('3', '二表本科');
INSERT INTO education_type VALUES ('4', '一表本科');
INSERT INTO education_type VALUES ('5', '研究生');
INSERT INTO education_type VALUES ('6', '博士生');

-- ----------------------------
-- Records of note_type
-- ----------------------------
INSERT INTO note_type VALUES ('0', '求助');

INSERT INTO note_type VALUES ('2', '心得');


-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO question_type VALUES ('0', '单项选择', '单项选择');
INSERT INTO question_type VALUES ('1', '多项选择', '多项选择');
INSERT INTO question_type VALUES ('2', '填空', '填空');
INSERT INTO question_type VALUES ('3', '判断', '判断');
INSERT INTO question_type VALUES ('4', '简答', '简答');


-- ----------------------------
-- Records of resource_type
-- ----------------------------
INSERT INTO resource_type VALUES ('0', '课堂代码', '课堂代码', 1);
INSERT INTO resource_type VALUES ('1', '相关工具', '相关工具', 2);
INSERT INTO resource_type VALUES ('2', '学习手册', '学习手册', 3);
INSERT INTO resource_type VALUES ('3', '本次作业', '本次作业', 4);

-- ----------------------------
-- Records of qstn_from_type
-- ----------------------------
INSERT INTO qstn_from_type VALUES ('1', '自定义', '说明: 自定义');
INSERT INTO qstn_from_type VALUES ('2', '面试整理', '说明: 面试整理');
INSERT INTO qstn_from_type VALUES ('3', '企业套题', '说明: 企业套题');
INSERT INTO qstn_from_type VALUES ('4', '网络收集', '说明: 网络收集');

-- ----------------------------
-- Records of study_card
-- ----------------------------
INSERT INTO study_card VALUES ('1', 'J2019000001', '123456', '30', '1');
INSERT INTO study_card VALUES ('2', 'J2019000002', '123456', '30', '1');
INSERT INTO study_card VALUES ('3', 'J2019000003', '123456', '30', '1');
INSERT INTO study_card VALUES ('4', 'J2019000004', '123456', '30', '1');
INSERT INTO study_card VALUES ('5', 'J2019000005', '123456', '30', '1');
INSERT INTO study_card VALUES ('6', 'J2019000006', '123456', '30', '1');
INSERT INTO study_card VALUES ('7', 'J2019000007', '123456', '30', '1');
INSERT INTO study_card VALUES ('8', 'J2019000008', '123456', '30', '0');
INSERT INTO study_card VALUES ('9', 'J2019000009', '123456', '30', '0');
INSERT INTO study_card VALUES ('10', 'J2019000010', '123456', '30', '0');
INSERT INTO study_card VALUES ('11', 'J2019000011', '123456', '30', '1');
INSERT INTO study_card VALUES ('12', 'J2019000012', '123456', '30', '1');
INSERT INTO study_card VALUES ('13', 'J2019000013', '123456', '30', '1');
INSERT INTO study_card VALUES ('14', 'J2019000014', '123456', '30', '0');
INSERT INTO study_card VALUES ('15', 'J2019000015', '123456', '30', '0');
INSERT INTO study_card VALUES ('16', 'J2019000016', '123456', '30', '0');

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO student VALUES ('1', '1', '4', '李小三', '燕子', '0', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('10', '2', '4', '赵静子', '不动', '0', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('2', '3', '4', '赵小四', '尼古拉斯', '1', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('3', '11', '4', '孙小六', '溜溜', '1', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('4', '4', '4', '刘小翠', '小绿', '0', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('5', '12', '4', '马小花', '兰花', '0', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('6', '5', '4', '武小奎', '大壮', '1', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('7', '10', '4', '张不开', '二爷', '1', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('8', '6', '4', '王小二', '小王', '1', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');
INSERT INTO student VALUES ('9', '7', '4', '闩小七', '气球', '1', '黑龙江科技大学', '电子技术', null, '666666', '13123456789', '13123456789', '13123456789', '13123456789@qq.com', '2019-04-30', '2019-05-30');


-- ----------------------------
-- Records of label_type
-- ----------------------------
INSERT INTO label_type VALUES ('0', '自定义标签', '说明: 自定义标签');
INSERT INTO label_type VALUES ('1', '学习程度', '说明: 学习程度');
INSERT INTO label_type VALUES ('2', '重点级别', '说明: 重点级别');
INSERT INTO label_type VALUES ('3', '难点级别', '说明: 难点级别');
INSERT INTO label_type VALUES ('4', '侧重点', '说明: 侧重点');
INSERT INTO label_type VALUES ('5', '学习进度', '说明: 学习进度');

-- ----------------------------
-- Records of label_tag
-- ----------------------------
INSERT INTO label_tag VALUES ('1', '1', null, '掌握', 'ZW', '说明: 掌握', null, '1');
INSERT INTO label_tag VALUES ('10', '1', null, '理解', 'LJ', '说明: 理解', null, '2');
INSERT INTO label_tag VALUES ('11', '1', null, '不熟练', 'BSL', '说明: 不熟练', null, '3');
INSERT INTO label_tag VALUES ('12', '1', null, '不理解', 'BLJ', '说明: 不理解', null, '4');
INSERT INTO label_tag VALUES ('13', '2', null, 'A级重点', 'ZDA', '说明: A级重点', null, '1');
INSERT INTO label_tag VALUES ('14', '2', null, 'B级重点', 'ZDB', '说明: B级重点', null, '2');
INSERT INTO label_tag VALUES ('15', '2', null, 'C级重点', 'ZDC', '说明: C级重点', null, '3');
INSERT INTO label_tag VALUES ('16', '3', null, 'A级难点', 'NDA', '说明: A级难点', null, '1');
INSERT INTO label_tag VALUES ('17', '3', null, 'B级难点', 'NDB', '说明: B级难点', null, '2');
INSERT INTO label_tag VALUES ('18', '3', null, 'C级难点', 'NDC', '说明: C级难点', null, '3');
INSERT INTO label_tag VALUES ('2', '4', null, '语法', 'YF', '说明: 语法', null, '1');
INSERT INTO label_tag VALUES ('3', '4', null, '算法逻辑', 'LJSF', '说明: 算法逻辑', null, '2');
INSERT INTO label_tag VALUES ('4', '4', null, '设计', 'SJ', '说明: 设计', null, '3');
INSERT INTO label_tag VALUES ('5', '4', null, '方法论', 'FFL', '说明: 方法论', null, '4');
INSERT INTO label_tag VALUES ('6', '4', null, '项目', 'XM', '说明: 项目', null, '5');
INSERT INTO label_tag VALUES ('7', '5', null, '计划学习', 'JHXX', '说明: 计划学习', null, '1');
INSERT INTO label_tag VALUES ('8', '5', null, '暂停学习', 'XTXX', '说明: 暂停学习', null, '2');
INSERT INTO label_tag VALUES ('9', '5', null, '再看一次', 'ZKYC', '说明: 再看一次', null, '3');



-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO teacher VALUES ('1', '关羽', '将军关羽是一个好老师', '1', '2010-07-16', null, 'gy', '123456');
INSERT INTO teacher VALUES ('2', '楚留香', '侠客楚留香是一个好老师', '0', '2014-07-25', null, 'clx', '123456');
INSERT INTO teacher VALUES ('3', '达摩', '佛家达摩是一个好老师', '1', '2016-07-15', null, 'dm', '123456');
INSERT INTO teacher VALUES ('4', '燕赤侠', '道士燕赤侠是一个好老师', '0', '2019-05-15', null, 'ycx', '123456');

-- ----------------------------
-- Records of subject_course
-- ----------------------------
INSERT INTO subject_course VALUES ('1', 'JavaSE', '1', 'JAVASE', '/home/images/xsxd_zxkc_p1.jpg', 'java语言基础语法',85);
INSERT INTO subject_course VALUES ('2', 'JavaWeb', '2', 'JAVAWEB', '/home/images/xsxd_zxkc_p2.jpg', 'java语言企业级开发',30);
INSERT INTO subject_course VALUES ('3', '数据库技术', '3', 'DATABASE', '/home/images/xsxd_zxkc_p7.jpg', '数据库技术',20);
INSERT INTO subject_course VALUES ('4', 'Linux技术', '4', 'LINUX', '/home/images/xsxd_zxkc_p3.jpg', 'Linux技术',50);
INSERT INTO subject_course VALUES ('5', 'Python语言', '5', 'PYTHON', '/home/images/xsxd_zxkc_p5.jpg', 'Python语言语法',0);
INSERT INTO subject_course VALUES ('6', 'C语言', '6', 'CLANG', '/home/images/xsxd_zxkc_p9.jpg', 'C语言技术',100);
INSERT INTO subject_course VALUES ('7', '算法与数据结构', '7', 'ALGOR', '/home/images/xsxd_zxkc_p10.jpg', '算法与数据结构技术',75);
INSERT INTO subject_course VALUES ('8', 'Spring全家桶', '8', 'SPRING', '/home/images/xsxd_zxkc_p11.jpg', 'Spring技术大全',35);

-- ----------------------------
-- Records of subj_unit
-- ----------------------------
INSERT INTO subj_unit VALUES ('01', '1', '1', 'Java学前准备', '1', 'JAVAAFTER', '学习Java学前准备', null);
INSERT INTO subj_unit VALUES ('02', '1', '1', '流程结构TGC学习法', '2', 'TGC', '学习流程结构TGC学习法', null);
INSERT INTO subj_unit VALUES ('03', '1', '1', 'Game框架', '3', 'GAMEFRAME', '学习Game框架', null);
INSERT INTO subj_unit VALUES ('04', '1', '1', '数组基础', '4', 'ARRAY', '学习数组基础', null);
INSERT INTO subj_unit VALUES ('05', '1', '3', '方法封装', '5', 'METHOD', '学习方法封装', null);
INSERT INTO subj_unit VALUES ('06', '1', '3', '类与对象', '6', 'CLASSOBJ', '学习类与对象', null);
INSERT INTO subj_unit VALUES ('07', '1', '3', '三性质', '7', 'ATTR', '学习五关系', null);
INSERT INTO subj_unit VALUES ('08', '1', '3', '五关系', '8', 'RELATION', '学习五关系', null);
INSERT INTO subj_unit VALUES ('09', '1', '1', '容器基础', '9', 'COLLECTION', '学习容器基础', null);
INSERT INTO subj_unit VALUES ('10', '1', '1', 'Java语法大全', '10', 'JAVABASE', '学习Java语法大全', null);
INSERT INTO subj_unit VALUES ('11', '2', '2', 'sql语言', '1', 'SQL', '学习sql语言', null);
INSERT INTO subj_unit VALUES ('13', '2', '2', 'MVC', '13', 'MVC', '学习MVC', null);
INSERT INTO subj_unit VALUES ('12', '2', '2', 'JDBC持久化操作 1 --前期准备', '6', 'JDBC1', 'JDBC持久化操作 1 --前期准备', null);
INSERT INTO subj_unit VALUES ('14', '2', '2', 'JDBC持久化操作 2 --基本步骤', '7', 'JDBC2', 'JDBC持久化操作 2 --基本步骤', null);
INSERT INTO subj_unit VALUES ('15', '2', '2', 'JDBC持久化操作 3 --预编译', '8', 'JDBC3', 'JDBC持久化操作 3 --预编译', null);
INSERT INTO subj_unit VALUES ('16', '2', '2', 'JDBC持久化操作 4 --事务管理', '9', 'JDBC4', 'JDBC持久化操作 4 --事务管理', null);
INSERT INTO subj_unit VALUES ('17', '2', '2', 'JDBC持久化操作 5 --DAO组件化', '10', 'JDBC5', 'JDBC持久化操作 5 --DAO组件化', null);
INSERT INTO subj_unit VALUES ('18', '2', '2', 'JDBC持久化操作 6 --Service层操作', '11', 'JDBC6', 'JDBC持久化操作 6 --Service层操作', null);


-- ----------------------------
-- Records of subj_section
-- ----------------------------
INSERT INTO subj_section VALUES ('01', '07', '什么是封装性', '1', 'FZX', '什么是封装性', null, null, '<p> 什么是封装性</p>\r\n<p> 如何写标准java类</p>\r\n<p>导出文档注释</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('02', '06', '书写标准java类', '1', 'BZJAVA', '书写标准java类', null, null, '<p>HashMap增</p>\r\n<p>HashMap删</p>\r\n<p>HashMap改</p>\r\n<p>HashMap查</p>\r\n<p>HashMap遍历</p>', null,  '2018-07-16');
INSERT INTO subj_section VALUES ('03', '09', 'HashMap操作', '6', 'HASHMAP', 'HashMap操作', null, null, '<p>容器常见异常</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('04', '09', 'ArrayList操作', '2', 'ARRAYLIST', 'ArrayList操作', null, null, '<p>eclipse的使用方法</p>\r\n<p> 管理工作空间：</p>\r\n<p> 项目创建与管理</p>\r\n<p>代码编辑技巧与常用快捷键 </p>\r\n<p> debug调试：断点、跳过与跳入、检查、表达式</p>\r\n<p>代码模板设置提高代码输入效率 </p>\r\n<p>任务与书签的运用快速定位代码位置 </p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('05', '09', 'HashSet操作', '4', 'HASHSET', 'HashSet操作', null, null, '<p></p>\r\n<p>什么是多态性</p>\r\n<p>代码实现多态性</p>\r\n<p>什么是“半盖”</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('06', '09', '与数组比较', '3', 'VSARRAY', '与数组比较', null, null, '<p>可视性（可见性）的作用</p>\r\n<p>private、protected、package、private的区别</p>\r\n<p>方法被覆盖时，可见性不能降低</p>\r\n<p></p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('07', '09', '其它容器', '9', 'OTHER', '其它容器', null, null, '<p>对象生命周期</p>\r\n<p>finalize()方法的作用</p>\r\n<p>System.gc()垃圾回收</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('08', '01', '什么是编程', '1', 'PROGRAM', '什么是编程', null, null, '<p>java.util.Date类常用方法</p>\r\n<p>java.sql.Date类常用方法</p>\r\n<p>日期格式化</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('09', '01', '敏锐识别流程结构', '2', 'LCJG', '敏锐识别流程结构', null, null, '<p>Math类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('10', '01', '英汉对照闯过语法关', '3', 'YFG', '英汉对照闯过语法关', null, null, '<p>接口定义常量</p>\r\n<p>接口意义</p>\r\n<p>接口的多继承</p>\r\n<p>类的单继承多实现</p>\r\n<p>接口回调</p>\r\n<p>接口与抽象类的区别</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('11', '01', '用调试工具闯过语义关', '4', 'YYG', '用调试工具闯过语义关', null, null, '<p>理解多线程概念</p>\r\n<p>熟练创建线程</p>\r\n<p>熟悉线程状态</p>\r\n<p>熟练控制线程</p>\r\n<p>能够解决线程同步问题</p>\r\n\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('12', '01', 'TGC学习法轻松过语用关', '5', 'YYONGG', 'TGC学习法轻松过语用关', null, null, '<p>理解socket通信概念</p>\r\n<p>掌握socket通信实例</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('13', '02', '顺序结构', '1', 'SXJG', '顺序结构', null, null, '<p>理解XML用途</p>\r\n<p>掌握XML解析</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('14', '02', '判断结构', '2', 'PDJG', '判断结构', null, null, '<p>理解反射机制用途</p>\r\n<p>掌握反射机制用法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('15', '03', '快速生成Game框架', '1', 'GAME', '快速生成Game框架', null, null, '<p>变量的类型与存储形态</p>\r\n<p>什么是进制；十进制、八进制、十六进制在程序中的写法</p>\r\n<p>整数类型：byte、short、int、long</p>\r\n<p>浮点(小数)类型：float单精度、double双精度</p>\r\n<p>布尔（逻辑）类型：boolean；值分别是true（真） false（假）\r\n</p>\r\n\r\n<p>字符类型char；字符的编码采用Unicode\r\n</p>\r\n<p>基本类型的转换：按优先级自动类型转换（也称隐式）与强制类型转换（也称显式）</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('16', '04', '一维数组', '2', 'ARRAY', '一维数组', null, null, '<p></p>\r\n<p> 类与对象基本关系</p>\r\n<p>如何使用类</p>\r\n<p>类与对象的执行原理</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('17', '05', '方法五要素', '1', 'METHOD', '方法五要素', null, null, '<p>理解注解概念</p>\r\n<p>掌握注解使用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('18', '08', '关联关系', '3', 'GLGX', '关联关系', null, null, '<p>只要是表达式就要有计算结果</p>\r\n<p>严格遵守运算符的计算方向</p>\r\n<p>理解多运算符混合表达式的优先级</p>\r\n<p>算术运算符：+、-、*、/、%、()</p>\r\n<p>赋值运算符：=、+=、-=、*=、/=、%=；++、--</p>\r\n<p>关系运算符：==、!=、>、>=、<、<=</p>\r\n<p>逻辑运算符：!、&&、||</p>\r\n<p>条件运算符：? :</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('19', '10', '终态应用', '4', 'ZTYY', '终态应用', null, null, '<p>BigDecimal类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('20', '11', 'DDL语法', '2', 'DDLSQL', 'DDL语法', null, null, '<p></p>\r\n<p>缺省构造</p>\r\n<p>构造重载</p>\r\n<p>构造代码块</p>\r\n<p>静态代码块</p>\r\n<p>this与super同名区分</p>\r\n<p>构造执行顺序</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('21', '11', 'DML语法', '3', 'DMLSQL', 'DML语法', null, null, '<p>包基本概念	</p>\r\n<p>创建包</p>\r\n<p>导入包</p>\r\n<p>生成jar包</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('22', '11', 'PLSQL工具的使用方法', '1', 'PLSQL', 'PLSQL工具的使用方法', null, null, '<p>StringBuffer类性能</p>\r\n<p>StringBuffer类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('25', '13', '传接值', '3', 'VALUE', '传接值', null, null, '<p>掌握流的分类</p>\r\n<p>掌握File常用方法</p>\r\n<p>掌握字节流</p>\r\n<p>掌握字符流</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('23', '12', '0.关系型数据库', '1', 'DRIVER', '0.关系型数据库', null, null, '<p>0.关系型数据库 static静态与非静态的区别</p>\r\n<p>static的变量与方法如何调用</p>\r\n<p>static静态代码块</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('24', '12', '1.JDBC概述', '2', 'RESULT', '1.JDBC概述', null, null, '<p>1.JDBC概述</p>\r\n<p>方法基本结构</p>\r\n<p>方法参数值传递</p>\r\n<p> 不确定实参个数</p>\r\n<p>方法重载overload</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('26', '12', '2.配置监听', '3', 'ARRAY', '2.配置监听', null, null, '<p>2.配置监听</p>\r\n<p> 类与对象基本关系</p>\r\n<p>如何使用类</p>\r\n<p>类与对象的执行原理</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('27', '12', '3.导入驱动Driver包', '4', 'METHOD', '3.导入驱动Driver包', null, null, '<p>3.导入驱动Driver包 理解注解概念</p>\r\n<p>掌握注解使用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('28', '14', '0.加载驱动建立连接', '1', 'GLGX', '0.加载驱动建立连接', null, null, '<p>0.加载驱动建立连接只要是表达式就要有计算结果</p>\r\n<p></p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('29', '14', '1.增删改操作', '2', 'ZTYY', '1.增删改操作', null, null, '<p>1.增删改操作BigDecimal类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('30', '14', '2.查询操作', '3', 'DDLSQL', '2.查询操作', null, null, '<p>2.查询操作</p>\r\n<p>缺省构造</p>\r\n<p>构造重载</p>\r\n<p>构造代码块</p>\r\n<p>静态代码块</p>\r\n<p>this与super同名区分</p>\r\n<p>构造执行顺序</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('31', '14', '3.释放资源', '4', 'DMLSQL', '3.释放资源', null, null, '<p>3.释放资源包基本概念	</p>\r\n<p>创建包</p>\r\n<p>导入包</p>\r\n<p>生成jar包</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('32', '14', '4.结果集元数据', '5', 'PLSQL', '4.结果集元数据', null, null, '<p>4.结果集元数据StringBuffer类性能</p>\r\n<p>StringBuffer类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('33', '14', '6.结果集封装', '6', 'DRIVER', '6.结果集封装', null, null, '<p>6.结果集封装static静态与非静态的区别</p>\r\n<p>static的变量与方法如何调用</p>\r\n<p>static静态代码块</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('34', '15', '0.SQL注入问题', '1', 'RESULT', '0.SQL注入问题', null, null, '<p>0.SQL注入问题</p>\r\n<p>方法基本结构</p>\r\n<p>方法参数值传递</p>\r\n<p> 不确定实参个数</p>\r\n<p>方法重载overload</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('35', '15', '1.预编译查询', '2', 'VALUE', '1.预编译查询', null, null, '<p>1.预编译查询掌握流的分类</p>\r\n<p>掌握File常用方法</p>\r\n<p>掌握字节流</p>\r\n<p>掌握字符流</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('36', '15', '2.预编译添加', '3', 'ARRAY', '2.预编译添加', null, null, '<p>2.预编译添加</p>\r\n<p> 类与对象基本关系</p>\r\n<p>如何使用类</p>\r\n<p>类与对象的执行原理</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('37', '16', '0.事务持久性', '1', 'METHOD', '0.事务持久性', null, null, '<p>0.事务持久性理解注解概念</p>\r\n<p>掌握注解使用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('38', '16', '1.事务原子性与一致性', '3', 'GLGX', '1.事务原子性与一致性', null, null, '<p>1.事务原子性与一致性只要是表达式就要有计算结果</p>\r\n<p>严格遵守运算符的计算方向</p>\r\n<p>理解多运算符混合表达式的优先级</p>\r\n<p>算术运算符：+、-、*、/、%、()</p>\r\n<p>赋值运算符：=、+=、-=、*=、/=、%=；++、--</p>\r\n<p>关系运算符：==、!=、>、>=、<、<=</p>\r\n<p>逻辑运算符：!、&&、||</p>\r\n<p>条件运算符：? :</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('39', '16', '2.事务隔离性', '4', 'ZTYY', '2.事务隔离性', null, null, '<p>2.事务隔离性BigDecimal类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('40', '16', '3.PLSQL工具的事务操作', '2', 'PLSQLTOOLS', 'DDL语法', null, null, '<p>3.PLSQL工具的事务操作</p>\r\n<p>缺省构造</p>\r\n<p>构造重载</p>\r\n<p>构造代码块</p>\r\n<p>静态代码块</p>\r\n<p>this与super同名区分</p>\r\n<p>构造执行顺序</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('41', '16', '4.JDBC事务操作', '3', 'DMLSQL', '4.JDBC事务操作', null, null, '<p>包基本概念	</p>4.JDBC事务操作\r\n<p>创建包</p>\r\n<p>导入包</p>\r\n<p>生成jar包</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('42', '17', '0.组件化概念', '1', 'PLSQL', '0.组件化概念', null, null, '0.组件化概念<p>StringBuffer类性能</p>\r\n<p>StringBuffer类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('43', '17', '1.DAO组件', '2', 'DRIVER', '1.DAO组件', null, null, '<p>static静态与非静态的区别</p>\r\n<p>static的变量与方法如何调用</p>\r\n<p>static静态代码块</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('44', '17', '3.将DAO类打包', '5', 'RESULT', '3.将DAO类打包', null, null, '<p>3.将DAO类打包</p>\r\n<p>方法基本结构</p>\r\n<p>方法参数值传递</p>\r\n<p> 不确定实参个数</p>\r\n<p>方法重载overload</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('45', '18', '0.建立service层', '3', 'value', '0.建立service层', null, null, '<p>0.建立service层掌握流的分类</p>\r\n<p>掌握File常用方法</p>\r\n<p>掌握字节流</p>\r\n<p>掌握字符流</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('46', '18', '1.service中的添加及测试', '2', 'ARRAY', '1.service中的添加及测试', null, null, '<p>1.service中的添加及测试</p>\r\n<p> 类与对象基本关系</p>\r\n<p>如何使用类</p>\r\n<p>类与对象的执行原理</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('47', '18', '2.service中修改', '1', 'METHOD', '2.service中修改', null, null, '<p>2.service中修改理解注解概念</p>\r\n<p>掌握注解使用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('48', '18', '3.service中查询', '3', 'GLGX', '3.service中查询', null, null, '<p>3.service中查询只要是表达式就要有计算结果</p>\r\n<p>严格遵守运算符的计算方向</p>\r\n<p>理解多运算符混合表达式的优先级</p>\r\n<p>算术运算符：+、-、*、/、%、()</p>\r\n<p>赋值运算符：=、+=、-=、*=、/=、%=；++、--</p>\r\n<p>关系运算符：==、!=、>、>=、<、<=</p>\r\n<p>逻辑运算符：!、&&、||</p>\r\n<p>条件运算符：? :</p>\r\n', null, '2018-07-16');
INSERT INTO subj_section VALUES ('49', '18', '4.srvice中删除', '4', 'ZTYY', '4.srvice中删除', null, null, '<p>4.srvice中删除BigDecimal类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('50', '18', '5.service中删除多条的第二种写法', '2', 'DDLSQL', '5.service中删除多条的第二种写法', null, null, '<p>5.service中删除多条的第二种写法</p>\r\n<p>缺省构造</p>\r\n<p>构造重载</p>\r\n<p>构造代码块</p>\r\n<p>静态代码块</p>\r\n<p>this与super同名区分</p>\r\n<p>构造执行顺序</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('51', '11', '分组SQL语句', '4', 'DMLSQL', '分组SQL语句', null, null, '<p>分组SQL语句包基本概念	</p>\r\n<p>创建包</p>\r\n<p>导入包</p>\r\n<p>生成jar包</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('52', '11', '连表操作', '1', 'PLSQL', '连表操作', null, null, '<p>连表操作StringBuffer类性能</p>\r\n<p>StringBuffer类常用方法</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('53', '13', '转页', '2', 'DRIVER', '转页', null, null, '<p>转页static静态与非静态的区别</p>\r\n<p>static的变量与方法如何调用</p>\r\n<p>static静态代码块</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('54', '13', '页面表达', '5', 'RESULT', '页面表达', null, null, '<p>页面表达</p>\r\n<p>方法基本结构</p>\r\n<p>方法参数值传递</p>\r\n<p> 不确定实参个数</p>\r\n<p>方法重载overload</p>', null, '2018-07-16');
INSERT INTO subj_section VALUES ('55', '13', 'Http协议', '3', 'VALUE', 'Http协议', null, null, '<p>Http协议掌握流的分类</p>\r\n<p>掌握File常用方法</p>\r\n<p>掌握字节流</p>\r\n<p>掌握字符流</p>\r\n', null, '2018-07-16');

-- ----------------------------
-- Records of resource_data
-- ----------------------------
INSERT INTO resource_data VALUES ('1', '01', '1', 'JDK8', null, '说明: JDK8', null);
INSERT INTO resource_data VALUES ('10', '03', '0', 'Game框架导入流程', null, '说明: Game框架导入流程', null);
INSERT INTO resource_data VALUES ('11', '03', '3', '小游戏训练', null, '说明: 小游戏训练', null);
INSERT INTO resource_data VALUES ('2', '01', '1', 'Eclipsez中文教学版', null, '说明: Eclipsez中文教学版', null);
INSERT INTO resource_data VALUES ('3', '01', '2', 'JDK7手册', null, '说明: JDK7手册', null);
INSERT INTO resource_data VALUES ('4', '01', '2', 'APIdemo大全', null, '说明: APIdemo大全', null);
INSERT INTO resource_data VALUES ('5', '01', '3', '基础训练', null, '说明: 基础训练', null);
INSERT INTO resource_data VALUES ('6', '01', '3', '深度训练', null, '说明: 深度训练', null);
INSERT INTO resource_data VALUES ('7', '01', '0', '流程结构与TGC', null, '说明: 流程结构与TGC', null);
INSERT INTO resource_data VALUES ('8', '01', '0', 'Demo流程结构', null, '说明: Demo流程结构', null);
INSERT INTO resource_data VALUES ('9', '01', '3', '高级训练', null, '说明: 高级训练', null);

-- ----------------------------
-- Records of PACKAGE_TYPE                                    
-- ----------------------------
insert into PACKAGE_TYPE  values ('1', '标准体验套餐', 10, 30, '01-05-2019' '1', '标准套餐');
insert into PACKAGE_TYPE  values ('2', '三连优惠套餐', 30, 100, '01-06-2019' '1', '三连优惠套餐');
insert into PACKAGE_TYPE  values ('3', '一年优惠套餐', 100, 365, '01-06-2019', '1', '一年优惠套餐');
insert into PACKAGE_TYPE  values ('4', '终身会员套餐', 16800, 36500, '01-06-2019',  '1', '终身会员套餐');
insert into PACKAGE_TYPE  values ('5', '终身霸王套餐', 168, 3650, '01-05-2019',  '0', '终身霸王套餐');
