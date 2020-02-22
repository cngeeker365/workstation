<map>
		<node ID="root" TEXT="Docker">		<node TEXT="目的" ID="6517051855f21168" STYLE="bubble" POSITION="right">
		<node TEXT="保证程序运行环境的一致性" ID="22d170518620230c4" STYLE="fork">
		</node>
		<node TEXT="降低配置开发环境、生产环境的复杂度和成本" ID="20170518648c402f" STYLE="fork">
		</node>
		<node TEXT="实现程序的快速部署和分发" ID="2a917051868382125" STYLE="fork">
		</node>
		</node>
		<node TEXT="架构" ID="1031705187272e06c" STYLE="bubble" POSITION="right">
		<node TEXT="架构图" ID="c91705187515d14f" STYLE="fork">
		<node TEXT="" ID="21217051882b6a0f" STYLE="fork">
		</node>
		<node TEXT="" ID="36517051966b1c136" STYLE="fork">
		</node>
		<node TEXT="Docker 采用 c/s 架构模式" ID="24a170518afa4e0f2" STYLE="fork">
		<node TEXT="Client  dockerCLI  ：客户端docker命令行" ID="1b1170518bb7510f9" STYLE="fork">
		</node>
		<node TEXT="REST  API：一套介于客户端与服务端之间进行通信并执行其指令的接口" ID="2af170518d235f18d" STYLE="fork">
		</node>
		<node TEXT="Server  docker  daemon：服务端docker 守护进程等待客户端发送命令来执行" ID="70170518dc5a10d5" STYLE="fork">
		</node>
		</node>
		<node TEXT="四大核心技术" ID="10c170518eeaa2027" STYLE="fork">
		<node TEXT="Image 镜像" ID="177170518f1018107" STYLE="fork">
		</node>
		<node TEXT="container 容器" ID="24217051915fd20c1" STYLE="fork">
		</node>
		<node TEXT="data  volumes  数据卷" ID="17f17051917e260e7" STYLE="fork">
		</node>
		<node TEXT="network 网络" ID="32d1705191b03e11b" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="优缺点" ID="3aa17051931a58073" STYLE="fork">
		<node TEXT="优点" ID="3e6170519329ad088" STYLE="fork">
		<node TEXT="适用场景多，环境部署快，使用人数多，省钱省力省人工" ID="1351705193411d04c" STYLE="fork">
		</node>
		</node>
		<node TEXT="缺点" ID="242170519334b509a" STYLE="fork">
		<node TEXT="依赖操作系统，依赖网络，U盾等场景不适用" ID="fc1705194f65d06c" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="安装与启动" ID="1f6170529518d2103" STYLE="bubble" POSITION="right">
		<node TEXT="基本命令" ID="1c51705295759801c" STYLE="fork">
		<node TEXT="systemctl  [参数]  docker" ID="3471705295fd620e2" STYLE="fork">
		</node>
		<node TEXT="参数" ID="28c17052965665171" STYLE="fork">
		<node TEXT="start          开启服务" ID="3da1705296670c032" STYLE="fork">
		</node>
		<node TEXT="stop           关闭" ID="22017052968cca02b" STYLE="fork">
		</node>
		<node TEXT="restart      重启" ID="ff1705296a3d80c4" STYLE="fork">
		</node>
		<node TEXT="status       状态" ID="2a11705296c50a0bf" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="基本目录" ID="18217052958f09106" STYLE="fork">
		<node TEXT="/etc/docker/                   docker的认证目录" ID="7170529794760e8" STYLE="fork">
		</node>
		<node TEXT="/var/lib/docker/            docker的应用目录" ID="1fc17052980b98095" STYLE="fork">
		</node>
		</node>
		<node TEXT="安装（centos）" ID="1c81705295ca5e109" STYLE="fork">
		<node TEXT="配置阿里云Docker Yum源" ID="210170529aa38c1" STYLE="fork">
		<node TEXT="yum install -y yum-utils device-mapper-persistent-data lvm2" ID="2f4170529bc75718a" STYLE="fork">
		</node>
		<node TEXT="yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo" ID="157170529bc9150eb1" STYLE="fork">
		</node>
		</node>
		<node TEXT="安装指定版本" ID="3ad170529afe1d0c7" STYLE="fork">
		<node TEXT="查看Docker版本" ID="c1170529bf869144" STYLE="fork">
		</node>
		<node TEXT="安装" ID="3c5170529c152a022" STYLE="fork">
		<node TEXT="安装较旧版本（比如Docker 17.03.1) 时需要指定完整的rpm包的包名，并且加上--setopt=obsoletes=0 参数" ID="394170529c814502d" STYLE="fork">
		<node TEXT="yum install -y --setopt=obsoletes=0   docker-ce-17.03.1.ce-1.el7.centos.x86_64   docker-ce-selinux-17.03.1.ce-1.el7.centos.noarch" ID="23170529d357e181" STYLE="fork">
		</node>
		</node>
		<node TEXT="安装Docker较新版本（比如Docker 18.03.0)时加上rpm包名的版本号部分" ID="b0170529c9363051" STYLE="fork">
		<node TEXT="yum install docker-ce-18.03.0.ce" ID="26170529d132d01" STYLE="fork">
		</node>
		</node>
		<node TEXT="安装Docker最新版本，无需加版本号" ID="1eb170529ccfbd165" STYLE="fork">
		<node TEXT="yum install docker-ce" ID="b6170529ceac901" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="删除" ID="3a41705295e7ff006" STYLE="fork">
		<node TEXT="yum remove docker docker-client  docker-client-latest  docker-common  docker-latest  docker-latest-logrotate  docker-logrotate  docker-selinux  docker-engine-selinux   docker-engine" ID="363170529728420bd" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="镜像管理" ID="3de1705104a84a08a" STYLE="bubble" POSITION="right">
		<node TEXT="总览图" ID="21417051828b05147" STYLE="fork">
		<node TEXT="" ID="291705183d68e08d" STYLE="fork">
		</node>
		</node>
		<node TEXT="搜索" ID="28a17051059bcc113" STYLE="fork">
		<node TEXT="docker   search   [镜像名称]" ID="1cf1705106118506f" STYLE="fork">
		<node TEXT="作用：搜索Docker Hub（镜像仓库）上的镜像" ID="38b170510695710eb" STYLE="fork">
		</node>
		<node TEXT="结果" ID="3571705108fc5313a" STYLE="fork">
		<node TEXT="Name（名称）" ID="10417051090de70b" STYLE="fork">
		</node>
		<node TEXT="Description（基本功能描述）" ID="31a17051091b09018" STYLE="fork">
		</node>
		<node TEXT="Stars（下载次数）" ID="36b170510926c20f1" STYLE="fork">
		</node>
		<node TEXT="Official（官方）" ID="183170510933a5116" STYLE="fork">
		</node>
		<node TEXT="Automated（自动运行）" ID="1f17051079c6109f" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="查看" ID="2ac1705105aa57171" STYLE="fork">
		<node TEXT="docker   images  [镜像名称]  /  docker  image  ls  [镜像名称]" ID="3c317051113b450be" STYLE="fork">
		<node TEXT="作用：查看本地镜像" ID="2451705112f422085" STYLE="fork">
		</node>
		<node TEXT="结果" ID="25c17051127b87189" STYLE="fork">
		<node TEXT="Repository（镜像名称）" ID="3701705113274d101" STYLE="fork">
		</node>
		<node TEXT="Tag（版本号）" ID="2a8170511394b9069" STYLE="fork">
		</node>
		<node TEXT="ImageID（镜像ID）" ID="2971705113c0170fc" STYLE="fork">
		</node>
		<node TEXT="Created（镜像的创建时间）" ID="3d9170511400950d5" STYLE="fork">
		</node>
		<node TEXT="Size（镜像的大小）" ID="27b17051142bfe036" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="获取" ID="3e21705105b3b906c" STYLE="fork">
		<node TEXT="docker    pull   [镜像名称]" ID="18717051096b9a155" STYLE="fork">
		<node TEXT="下载远程仓库（如Docker Hub）中的镜像" ID="2141705109e8d801d" STYLE="fork">
		</node>
		<node TEXT="镜像存放位置" ID="334170510bb7a116f" STYLE="fork">
		<node TEXT="/var/lib/docker" ID="31d170510bf94e146" STYLE="fork">
		<node TEXT="image/overlay2/repositories.json：查看相关镜像信息" ID="ff17051104898083" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="重命名" ID="4f1705114ea0709c" STYLE="fork">
		<node TEXT="docker   tag   [老镜像名称]:[老镜像版本]   [新镜像名称]:[新镜像版本]" ID="2a9170511521ef073" STYLE="fork">
		<node TEXT="作用：对本地镜像的Name、Tag进行重命名，并新产生一个命名后的镜像，新老镜像都在，imageID相同" ID="3d51705116ebe4169" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="删除" ID="2a417051150985088" STYLE="fork">
		<node TEXT="docker   rmi   [命令参数]  [镜像ID]" ID="2b91705118ae110fd" STYLE="fork">
		</node>
		<node TEXT="docker   rmi   [命令参数]  [镜像名称]:[镜像版本]" ID="e01705119eb97028" STYLE="fork">
		</node>
		<node TEXT="docker   image   rm   [命令参数] [镜像]" ID="19b170511a6ca508e" STYLE="fork">
		<node TEXT="参数：-f,   --force    强制删除" ID="1d7170511b015d146" STYLE="fork">
		</node>
		<node TEXT="注意：若一个imageID有多个名称，则应使用  [名称]:[版本]  格式删除" ID="2fc170511bdc1300a" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="导出" ID="338170511d55a5011" STYLE="fork">
		<node TEXT="docker   save   [命令参数]   [导出镜像名称]  [本地镜像]" ID="2bd170511d84e8089" STYLE="fork">
		<node TEXT="作用：将本地的一个或多个镜像打包并保存为本地tar文件" ID="37e170511e2dff18d" STYLE="fork">
		</node>
		<node TEXT="参数：-o  --output   string          指定写入的文件名和路径" ID="235170511edbf8061" STYLE="fork">
		</node>
		<node TEXT="实例：docker  save  -o   nginx.tar   nginx" ID="2a1170511f9790087" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="导入" ID="297170511d684c0b8" STYLE="fork">
		<node TEXT="docker   load  [命令参数]  [镜像压缩包名称]" ID="3d4170512060d307b" STYLE="fork">
		</node>
		<node TEXT="docker   load  <  [镜像压缩包名称]" ID="1a717051214e08177" STYLE="fork">
		</node>
		<node TEXT="docker   load  --input   [镜像压缩包名称]" ID="3c617051219225147" STYLE="fork">
		<node TEXT="作用：将save命令打包的镜像导入本地镜像库中" ID="2fb1705122076d19" STYLE="fork">
		</node>
		<node TEXT="参数：-i，--input   string       指定要导入的文件，若未指定，默认是 STDIN" ID="12f17051224e1403e" STYLE="fork">
		</node>
		<node TEXT="注意：若导入时无权限，需chmod修改镜像文件的权限" ID="261170512324f7124" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="查看镜像历史" ID="461705124679f08e" STYLE="fork">
		<node TEXT="docker   history   [镜像名称]:[镜像版本]" ID="2f31705124f76a01d" STYLE="fork">
		</node>
		<node TEXT="docker   history   [镜像ID]" ID="34517051254bfb157" STYLE="fork">
		<node TEXT="作用：查看本地一个镜像的历史（历史分层）信息，如启动了哪些命令或封装了哪些系统层" ID="14e1705125ba47174" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="查看镜像详细信息" ID="3e2170517b6a8c0c1" STYLE="fork">
		<node TEXT="docker   image   inspect  [命令参数]  [镜像名称]:[镜像版本]" ID="4d170517baf8a158" STYLE="fork">
		</node>
		<node TEXT="docker   inspect  [命令参数]  [镜像ID]" ID="d3170517c3ccd15" STYLE="fork">
		</node>
		</node>
		<node TEXT="根据模板创建镜像" ID="137170517ce0b50e9" STYLE="fork">
		<node TEXT="登录系统模板镜像网站" ID="386170517d5f450a" STYLE="fork">
		<node TEXT="https://download.openvz.org/template/precreated" ID="6170517da3470af" STYLE="fork">
		</node>
		</node>
		<node TEXT="下载镜像模板文件，如 ubuntu-16.04-x86_64.tar.gz" ID="2f2170517fa187009" STYLE="fork">
		</node>
		<node TEXT="命令：cat   模板文件名   |   docker  import  -  [自定义镜像名]" ID="26c17051804ae80ac" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="容器管理" ID="1f01705184cad60b5" STYLE="bubble" POSITION="left">
		<node TEXT="总览" ID="2b91705184dab50db" STYLE="fork">
		<node TEXT="容器与虚拟机比较" ID="3311705198bd9f012" STYLE="fork">
		<node TEXT="相同点" ID="6c1705198f57b13a" STYLE="fork">
		<node TEXT="对物理硬件资源共享使用" ID="14617051999d10071" STYLE="fork">
		</node>
		<node TEXT="生命周期相似（创建、运行、暂停、关闭等）" ID="1c1170519a0edf111" STYLE="fork">
		</node>
		<node TEXT="都可以安装各种应用" ID="36d170519a6c2f07e" STYLE="fork">
		</node>
		<node TEXT="创建后会存储在宿主机上（/var/lib/docker/containers）" ID="3d0170519be96c069" STYLE="fork">
		</node>
		</node>
		<node TEXT="不同点" ID="3bd170519904c4192" STYLE="fork">
		<node TEXT="虚拟器是基于一个完整的操作系统，容器直接运行在宿主机内核，本质上是一系列进程的结合" ID="108170519d4c4f13c" STYLE="fork">
		</node>
		<node TEXT="虚拟机是重量级，容器是轻量级（无需额外资源来管理，能耗低）" ID="362170519df5890ee" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="虚拟机生命周期" ID="20017051a16c6417" STYLE="fork">
		<node TEXT="" ID="6517051a1f5ee12" STYLE="fork">
		</node>
		</node>
		<node TEXT="docker容器生命周期" ID="18117051a1db5e0b6" STYLE="fork">
		<node TEXT="" ID="3a617051a47e8107a" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="查看" ID="4417051850037028" STYLE="fork">
		<node TEXT="docker  ps   -a" ID="c217051a80d08122" STYLE="fork">
		<node TEXT="container ID  容器ID" ID="1ff17051a84ba1174" STYLE="fork">
		</node>
		<node TEXT="image  基于哪个镜像" ID="25b17051a93f0900f" STYLE="fork">
		</node>
		<node TEXT="command   运行镜像使用了哪些命令" ID="2d617051a95fa70fb" STYLE="fork">
		</node>
		<node TEXT="created   多久前创建的" ID="21817051a99d9f199" STYLE="fork">
		</node>
		<node TEXT="status   开启还是关闭" ID="25917051a9dafc096" STYLE="fork">
		</node>
		<node TEXT="ports   端口号" ID="29817051a9fd5e14" STYLE="fork">
		</node>
		<node TEXT="names   容器名称，默认随机" ID="7717051aa1a22075" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="创建" ID="1817051a0d889061" STYLE="fork">
		<node TEXT="docker   create  [OPTIONS]   IMAGE    [COMMAND]   [ARG...]" ID="1dd17051aaa04e075" STYLE="fork">
		<node TEXT="Options" ID="13d17051ab88a018f" STYLE="fork">
		<node TEXT="-t,  --tty      模拟中断" ID="29617051abf79c074" STYLE="fork">
		</node>
		<node TEXT="-i                  保持STDIN打开" ID="28c17051ac3b540ee" STYLE="fork">
		</node>
		<node TEXT="--name      为容器起名，若没有指定则随机产生" ID="15b17051ac926f18e" STYLE="fork">
		</node>
		</node>
		<node TEXT="Command/Arg" ID="ab17051abcac811c" STYLE="fork">
		<node TEXT="COMMAND：容器启动后执行的命令，如ps、ls等" ID="cf17051adba220a9" STYLE="fork">
		</node>
		<node TEXT="ARG：执行COMMAND需提供的参数，如 ps 命令的aux、ls的 -a 等" ID="a917051ae2d820f1" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="启动" ID="20517051a0e33b074" STYLE="fork">
		<node TEXT="启动待启动或已关闭容器" ID="23a17051af401e17b" STYLE="fork">
		<node TEXT="docker  start  [容器名称 | ID]" ID="2ef17051b0a0cb19a" STYLE="fork">
		</node>
		<node TEXT="参数：" ID="3ad17051b12aee04e" STYLE="fork">
		<node TEXT="-a：将当前shell的  STDOUT / STDERR  连接到容器上" ID="2eb17051b150f611d" STYLE="fork">
		</node>
		<node TEXT="-i：将当前shell的  STDIN  连接到容器上" ID="21f17051b1eb2916e" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="基于镜像新建一个容器并启动" ID="27b17051af8faa15d" STYLE="fork">
		<node TEXT="docker   run  [命令参数]   [镜像名称]   [执行的命令]" ID="ff17051b296bb0fa" STYLE="fork">
		</node>
		<node TEXT="参数" ID="14317051b323f1193" STYLE="fork">
		<node TEXT="-t      分配虚拟终端" ID="34817051b333f7034" STYLE="fork">
		</node>
		<node TEXT="-i      保持  STDIN  打开" ID="37217051b376e802" STYLE="fork">
		</node>
		<node TEXT="-d     后台运行，并打印容器ID" ID="b917051b3c2a216c" STYLE="fork">
		</node>
		<node TEXT="--name     容器名字" ID="27717051b41d41189" STYLE="fork">
		</node>
		<node TEXT="--rm     当容器退出运行时，自动删除容器" ID="31117051be58e30c" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="守护进程方式启动docker" ID="2f217051afbca0074" STYLE="fork">
		<node TEXT="docker  run  -d  [image_name]  command  ..." ID="29617051bee0bb0dc" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="暂停" ID="9f17051c1426f003" STYLE="fork">
		<node TEXT="docker   pause   [container_name | container_id]" ID="2e217051c1b1d20d1" STYLE="fork">
		</node>
		</node>
		<node TEXT="取消暂停" ID="6f17051c2cf8b17d" STYLE="fork">
		<node TEXT="docker   unpause   [container_name | container_id]" ID="27317051c31cda13e" STYLE="fork">
		</node>
		</node>
		<node TEXT="重启" ID="3a217051c307670ff" STYLE="fork">
		<node TEXT="docker   restart   [container_name | container_id]" ID="28917051c440ae0df" STYLE="fork">
		</node>
		<node TEXT="参数" ID="3ad17051c4b1c5108" STYLE="fork">
		<node TEXT="-t，--time    int           重启前，等待的时间，单位秒（默认10s）" ID="2ab17051c4ca0806b" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="延迟关闭" ID="35e17051d85c4d144" STYLE="fork">
		<node TEXT="docker  stop   [container_name | container_id]" ID="10e17051d8918618" STYLE="fork">
		</node>
		</node>
		<node TEXT="强制终止" ID="23c17051d866c0073" STYLE="fork">
		<node TEXT="docker   kill   [container_name  |  container_id]" ID="37117051d8f65c0b6" STYLE="fork">
		</node>
		</node>
		<node TEXT="删除" ID="10e17051d876d0073" STYLE="fork">
		<node TEXT="删除已关闭" ID="2fe17051da6a37036" STYLE="fork">
		<node TEXT="docker   rm  [container_name | container_id]" ID="cb17051db175c0a" STYLE="fork">
		</node>
		</node>
		<node TEXT="强制删除运行中" ID="2c817051daa164132" STYLE="fork">
		<node TEXT="docker  rm  -f  [container_name | container_id]" ID="3ac17051db79d9104" STYLE="fork">
		</node>
		</node>
		<node TEXT="强制删除批量" ID="5a17051dab4ec113" STYLE="fork">
		<node TEXT="docker  rm  -f  $(docker  ps  -a  -q)" ID="2b017051dc2eff0e5" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="进入" ID="fc17051dcde6004e" STYLE="fork">
		<node TEXT="创建时进入" ID="18617051dd0bfa057" STYLE="fork">
		<node TEXT="docker   run  --name  [container_name]  -it  [docker_image]  /bin/bash" ID="24517051ddce12091" STYLE="fork">
		</node>
		</node>
		<node TEXT="手工方式进入" ID="1a517051dd255f063" STYLE="fork">
		<node TEXT="docker  exec  -it  container_id   /bin/bash" ID="e217051df000c19" STYLE="fork">
		</node>
		</node>
		<node TEXT="生产方式进入" ID="2e217051dd3fd715e" STYLE="fork">
		<node TEXT="定义脚本" ID="1e817051e01e54015" STYLE="fork">
		<node TEXT="" ID="34017051e0cbdb011" STYLE="fork">
		</node>
		</node>
		<node TEXT="赋权并执行" ID="c317051e0c14f18b" STYLE="fork">
		<node TEXT="" ID="6e17051e10c1c119" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="退出" ID="26617051dcf430006" STYLE="fork">
		<node TEXT="exit" ID="2c017051deaf25068" STYLE="fork">
		</node>
		<node TEXT="ctrl + d" ID="18b17051deb8d107" STYLE="fork">
		</node>
		</node>
		<node TEXT="基于容器创建镜像" ID="1ae17051e23aef13a" STYLE="fork">
		<node TEXT="方式一" ID="2f217051e39840089" STYLE="fork">
		<node TEXT="docker   commit   -m   '改动信息'  -a  &quot;作者信息&quot;   [container_id]  [new_image:tag]" ID="24f17051e263f5159" STYLE="fork">
		</node>
		</node>
		<node TEXT="方式二" ID="20717051e3ffc40bd" STYLE="fork">
		<node TEXT="导出" ID="35117051e54ed00b5" STYLE="fork">
		<node TEXT="docker   export   [容器id]   >  模板文件名.tar" ID="1ff17051e4108f0b5" STYLE="fork">
		</node>
		<node TEXT="export  vs.  save" ID="18717051e6a9d2065" STYLE="fork">
		<node TEXT="export 导出的镜像文件大小 ， 小于 save 保存的镜像" ID="24117051e703e90fb" STYLE="fork">
		</node>
		<node TEXT="export 导出（import导入）是根据容器拿到的镜像，再导入时会丢失镜像所有的历史" ID="2ee17051e769c302b" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="导入" ID="22117051e573c8035" STYLE="fork">
		<node TEXT="cat  模板文件名.tar   |  docker  import  -  镜像名" ID="7d17051e580850db" STYLE="fork">
		</node>
		<node TEXT="import  vs.  load" ID="22817051e66e0f17e" STYLE="fork">
		<node TEXT="import  可以重新制定镜像的名字" ID="34717051e82dc20f1" STYLE="fork">
		</node>
		<node TEXT="load不可以" ID="35d17051e8639d057" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="查看容器其他信息" ID="23717051f99598148" STYLE="fork">
		<node TEXT="运行日志" ID="19917051e91b4d14b" STYLE="fork">
		<node TEXT="docker   logs   [容器id]" ID="2ea17051e93b31132" STYLE="fork">
		</node>
		</node>
		<node TEXT="详细信息" ID="14317051f8e3c3142" STYLE="fork">
		<node TEXT="docker   inspect  [容器id]" ID="30617051f901fd053" STYLE="fork">
		</node>
		</node>
		<node TEXT="端口" ID="31617051f9ea6812b" STYLE="fork">
		<node TEXT="docker   port   [容器id]" ID="39b17051fa05b3092" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="重命名" ID="9c17051faab45114" STYLE="fork">
		<node TEXT="docker   rename   [容器id 或 容器名称]   [容器新名词]" ID="36c17051fad83f0ef" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="数据管理" ID="27e17052044b2509c" STYLE="bubble" POSITION="left">
		<node TEXT="数据卷 Data Volume" ID="7417052045bb5136" STYLE="fork">
		<node TEXT="特性" ID="3cb170522e5e3611b" STYLE="fork">
		<node TEXT="数据卷可以在容器之间共享和重用，本地与容器间传递数据更有效" ID="2f0170522f03330e3" STYLE="fork">
		</node>
		<node TEXT="对数据卷的修改会立即生效，容器内部与本地目录均可" ID="29d17052344b2c196" STYLE="fork">
		</node>
		<node TEXT="对数据卷的更新，不会影响镜像，对数据和应用进行了解耦操作" ID="1fc17052349bb2085" STYLE="fork">
		</node>
		<node TEXT="卷会一直存在，直到没有容器使用" ID="1c61705234ee6814c" STYLE="fork">
		</node>
		</node>
		<node TEXT="命令" ID="9217052359a47167" STYLE="fork">
		<node TEXT="docker   run  [命令参数] ..." ID="571705235ae58147" STYLE="fork">
		<node TEXT="参数" ID="3641705236214a0f3" STYLE="fork">
		<node TEXT="-v，--volume  list        挂载一个数据卷，默认为空（若本地路径不存在，会自动创建）" ID="19c1705236362e0e4" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="管理" ID="13a1705246c5db091" STYLE="fork">
		<node TEXT="目录" ID="4817052472a580e9" STYLE="fork">
		<node TEXT="docker   run   -itd  --name  [container_name]  -v [宿主机目录(绝对路径)]:[容器目录]   [镜像名称]  [命令(可选)]" ID="1261705247719512b" STYLE="fork">
		</node>
		</node>
		<node TEXT="普通文件(不推荐)" ID="3791705247361d01f" STYLE="fork">
		<node TEXT="docker   run   -itd  --name  [container_name]  -v [宿主机文件]:[容器文件]   [镜像名称]  [命令(可选)]" ID="2d317052492e34106" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="注意" ID="26d170524a032401a" STYLE="fork">
		<node TEXT="Docker挂载数据卷默认为读写权限（rw），用户可以通过ro设置为只读" ID="2af170524a134e054" STYLE="fork">
		<node TEXT="格式：[宿主机文件]:[容器文件]:ro" ID="344170524acdd3103" STYLE="fork">
		</node>
		</node>
		<node TEXT="直接挂载文件到容器，使用文件工具编辑，可能造成文件改变，会报错，建议直接挂载在文件所在的目录" ID="3d8170524b47290c2" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="数据卷容器 Data Volume Containers" ID="fa17052046c8c168" STYLE="fork">
		<node TEXT="简介" ID="182170525ca32012f" STYLE="fork">
		<node TEXT="数据卷容器就是为其他容器提供数据交互存储的容器" ID="2bc170525ce61115f" STYLE="fork">
		</node>
		<node TEXT="数据卷容器自身不需要启动" ID="312170525e6db609" STYLE="fork">
		</node>
		</node>
		<node TEXT="操作流程" ID="71170525d53e10d2" STYLE="fork">
		<node TEXT="创建数据卷容器" ID="378170525e080e0a9" STYLE="fork">
		<node TEXT="命令：docker   create  -v   [容器数据卷目录]   --name   [容器名字]  [镜像名称]   [命令（可选）]" ID="37170525f57d613c" STYLE="fork">
		</node>
		<node TEXT="实例：docker   create  -v  /data  --name  v1-test1   nginx" ID="24b1705260d9dd09f" STYLE="fork">
		</node>
		</node>
		<node TEXT="其他容器挂载数据卷容器" ID="23f170525e3617108" STYLE="fork">
		<node TEXT="命令：docker   run   --volumes-from   [数据卷容器id/name]   -tid  --name  [容器名称]  [镜像名称]  [命令(可选)]" ID="1c3170526150690c9" STYLE="fork">
		</node>
		<node TEXT="实例：" ID="31c17052627b550f5" STYLE="fork">
		<node TEXT="docker  run  --volumes-from  4693558c49e8   -tid  --name   vc-test1   nginx   /bin/bash" ID="13e1705262adb9009" STYLE="fork">
		</node>
		<node TEXT="docker  run  --volumes-from  4693558c49e8   -tid  --name   vc-test2   nginx   /bin/bash" ID="23e170526657c111" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="数据备份与恢复" ID="14f17052678d44029" STYLE="fork">
		<node TEXT="原理图" ID="1931705267b1d407b" STYLE="fork">
		<node TEXT="" ID="1cc1705268824717" STYLE="fork">
		</node>
		</node>
		<node TEXT="方案说明" ID="df170526b64340ca" STYLE="fork">
		<node TEXT="创建一个挂载数据卷容器的容器" ID="6e170526b878117" STYLE="fork">
		</node>
		<node TEXT="挂载宿主机本地目录作为备份数据卷" ID="224170526c28e307d" STYLE="fork">
		</node>
		<node TEXT="将数据卷容器的内容备份到宿主机本地目录挂载的数据卷中" ID="287170526d1c87176" STYLE="fork">
		</node>
		<node TEXT="完成备份操作后销毁刚刚创建的容器" ID="c5170526d996009a" STYLE="fork">
		</node>
		</node>
		<node TEXT="命令" ID="b71705271a5730fb" STYLE="fork">
		<node TEXT="格式" ID="28d1705271cb1813e" STYLE="fork">
		<node TEXT="docker  run  --rm  --volumes-from  [数据卷容器id/name]  -v  [宿主机目录]:[容器目录]  [镜像名称]  [备份命令]" ID="5c1705271ec56188" STYLE="fork">
		</node>
		</node>
		<node TEXT="演示" ID="32d17052686efd07d" STYLE="fork">
		<node TEXT="创建备份目录" ID="236170526fa250129" STYLE="fork">
		<node TEXT="mkdir   /testdir/backup/" ID="3c9170526fd37d0d2" STYLE="fork">
		</node>
		</node>
		<node TEXT="创建备份容器" ID="22117052703a5006b" STYLE="fork">
		<node TEXT="docker run  --rm  --volumes-from 4693558c49e8  -v  /testdir/backup/:/backup/   nginx   tar  zcPf  /backup/data.tar.gz  /data" ID="31170526ae3e10d71" STYLE="fork">
		<node TEXT="-P：使用源文件的原来属性（属性不会依据使用者而变），恢复字段到它们的原始方式，忽略现有的用户权限屏蔽(umask)。若用root用户操作，则加不加都一样。" ID="2f817052732afb134" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="网络管理" ID="28a17052a284d8055" STYLE="bubble" POSITION="left">
		<node TEXT="端口映射" ID="d817052a29a080f4" STYLE="fork">
		<node TEXT="随机映射： " ID="2e617052e2049613b" STYLE="fork">
		<node TEXT="默认随机映射" ID="22d17052e3dea60bd" STYLE="fork">
		<node TEXT="docker   run  -d   -P   --name  [容器名称]  [镜像名称]" ID="12417052e2f38c132" STYLE="fork">
		</node>
		</node>
		<node TEXT="指定主机随机映射" ID="1d917052e389410e1" STYLE="fork">
		<node TEXT=" docker  run  -d  -p  [宿主机ip]::[容器端口]  --name  [容器名称]  [镜像名称]" ID="2117052e04ef30c6" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="指定映射： -p  宿主机ip:宿主机端口:容器端口" ID="1de17052de7309198" STYLE="fork">
		<node TEXT="指定端口映射 " ID="1bc17052e61d89151" STYLE="fork">
		<node TEXT="docker  run  -d  -p  [宿主机ip]:[宿主机端口]:[容器端口]  --name  [容器名称]  [镜像名称]" ID="29617052e47a37094" STYLE="fork">
		<node TEXT="不指定宿主机ip的话，默认使用  0.0.0.0" ID="21217052e4c63d033" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="多端口映射" ID="917052e665ce01e" STYLE="fork">
		<node TEXT="docker  run  -d  -p [宿主机端口1]:[容器端口1]  -p [宿主机端口2]:[容器端口2]    --name  [容器名称]  [镜像名称]" ID="28417052e67a5e12d" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="网络命令" ID="d217052e778a5054" STYLE="fork">
		<node TEXT="docker   network   help   查看网络命令帮助" ID="cb17052e789bd02" STYLE="fork">
		<node TEXT="connect                将一个容器连接到一个网络" ID="717052e7e5c917c" STYLE="fork">
		<node TEXT="--gateway  strings             主子网的IPv4或IPv6网关" ID="2901705303ca8303b" STYLE="fork">
		</node>
		<node TEXT="--subnet  strings                表示网络段的CIDR格式的子网" ID="1d9170530478ba048" STYLE="fork">
		</node>
		</node>
		<node TEXT="disconnect          从网络断开一个容器" ID="23d17052e87c1e02b" STYLE="fork">
		</node>
		<node TEXT="create                    创建一个网络" ID="a17052e81c6b0ac" STYLE="fork">
		</node>
		<node TEXT="inspect                  在一个或多个网络上显示详细信息" ID="35017052e8d57701" STYLE="fork">
		<node TEXT="" ID="3e317052ea902410e" STYLE="fork">
		</node>
		</node>
		<node TEXT="ls                              查看网络列表" ID="9817052e93ac913a" STYLE="fork">
		<node TEXT="" ID="3c417052ea685a0b7" STYLE="fork">
		</node>
		</node>
		<node TEXT="rm                            删除一个或多个网络" ID="11a17052e96b79138" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="网络模式" ID="28217052eda254117" STYLE="fork">
		<node TEXT="bridge模式（默认）" ID="f117052edf5f20a3" STYLE="fork">
		<node TEXT="简介" ID="2f117052ee840a12a" STYLE="fork">
		<node TEXT="在容器启动时，自动配置好自己的网络信息" ID="2a117052ee9dd10b7" STYLE="fork">
		</node>
		<node TEXT="同一宿主机的所有容器都在一个网络下，彼此之间可以通信" ID="29f17052ef32be07c" STYLE="fork">
		</node>
		<node TEXT="利用宿主机网卡通信，涉及网络转换，造成资源消耗，网络效率低" ID="2017052ef88d104f" STYLE="fork">
		</node>
		<node TEXT="" ID="13317052f07ffa076" STYLE="fork">
		</node>
		</node>
		<node TEXT="定制 bridge 实践一" ID="36e17052f5a81f0fc" STYLE="fork">
		<node TEXT="创建网络" ID="23317052f6385b0ac" STYLE="fork">
		<node TEXT="命令：docker   network  create  --driver  [网络类型]  [网络名称]" ID="3a517052f67e140be" STYLE="fork">
		</node>
		<node TEXT="演示：docker  network  create  --driver  bridge  bridge-test" ID="3c417052f8313918f" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看网络" ID="25517052f9c81b13a" STYLE="fork">
		<node TEXT="docker  network  inspect  bridge-test" ID="2ed17052f9ef2b132" STYLE="fork">
		</node>
		<node TEXT="ifconfig" ID="21b17052fa4f36067" STYLE="fork">
		</node>
		</node>
		<node TEXT="自定义网段与网关" ID="22417052fa7416122" STYLE="fork">
		<node TEXT="docker   network   create  --driver  birdge  --gateway  172.99.0.1   --subnet  172.99.0.0/16    bridge-test1" ID="1ce1705303452a151" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看网络" ID="2f31705306547315d" STYLE="fork">
		<node TEXT="docker   network   ls" ID="a117053066e9311" STYLE="fork">
		</node>
		<node TEXT="docker   network   inspect  bridge-test1" ID="16f1705307598903d" STYLE="fork">
		</node>
		<node TEXT="ifconfig" ID="13117053073a54197" STYLE="fork">
		</node>
		</node>
		<node TEXT="在自定义网络中启动容器" ID="1b81705307c90e155" STYLE="fork">
		<node TEXT="命令： docker  run  --net=[网络名称]  -itd  --name=[容器名称]  [镜像名称]" ID="36c1705307fc3805c" STYLE="fork">
		</node>
		<node TEXT="实例：" ID="356170530a4d1508b" STYLE="fork">
		<node TEXT="docker  run  --net=birdge-test    -itd  --name  nginx-1   nginx" ID="cd17053091382034" STYLE="fork">
		</node>
		<node TEXT="docker  run  --net=birdge-test1  -itd  --name  nginx-2   nginx" ID="262170530a604411e" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="注意" ID="3a8170530b445607a" STYLE="fork">
		<node TEXT="使用默认的桥接模型创建的容器是可以直接联网的" ID="18c170530b4e6717a" STYLE="fork">
		</node>
		<node TEXT="使用自定义的桥接模型创建的容器不可以直接联网，但是可以通过端口映射来实现联网" ID="3e5170530b8e29142" STYLE="fork">
		</node>
		</node>
		<node TEXT="容器断开网络" ID="37a170530c7c4c057" STYLE="fork">
		<node TEXT="命令：docker  network  disconnect  [网络名]  [容器名]" ID="2fc170530c96ab0e1" STYLE="fork">
		</node>
		<node TEXT="实例：" ID="d2170530cf0ce0f3" STYLE="fork">
		<node TEXT="docker  network  disconnect  bridge-test  nginx-1" ID="1e4170530d21d2017" STYLE="fork">
		</node>
		<node TEXT="docker  network  disconnect  bridge-test1  nginx-2" ID="22f170530d637e019" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="查看网络" ID="317170530e01800fb" STYLE="fork">
		<node TEXT="docker network ls" ID="3df170530e1ed70c4" STYLE="fork">
		</node>
		<node TEXT="docker network inspect bridge-test1" ID="145170530e20e50891" STYLE="fork">
		</node>
		<node TEXT="ifconfig" ID="f4170530e20e51732" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="定制 bridge 实践二" ID="122170530f2df00b3" STYLE="fork">
		<node TEXT="创建网桥" ID="118170531475e804c" STYLE="fork">
		<node TEXT="之前创建的容器，ip都是从默认网桥docker0自动获取" ID="31705316c9b2038" STYLE="fork">
		</node>
		</node>
		<node TEXT="docker服务使用新网桥" ID="d91705314ce93195" STYLE="fork">
		<node TEXT="创建网桥" ID="3de170531921af0fb" STYLE="fork">
		<node TEXT="网桥软件部署" ID="306170532494330ae" STYLE="fork">
		<node TEXT="apt-get  install  bridge-utils  -y" ID="1f71705324c35205d" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看网卡" ID="ac1705325239b125" STYLE="fork">
		<node TEXT="brctl   show" ID="2a217053253b2516b" STYLE="fork">
		</node>
		</node>
		<node TEXT="创建网桥 br0" ID="2f4170532574cf16b" STYLE="fork">
		<node TEXT="brctl  addbr  br0" ID="ea1705325b54e089" STYLE="fork">
		</node>
		</node>
		<node TEXT="给网桥设置网段" ID="e2170532610a8093" STYLE="fork">
		<node TEXT="ifconfig  br0  192.168.99.1  netmask  255.255.255.0" ID="249170532648f8132" STYLE="fork">
		</node>
		<node TEXT="ifconfig" ID="8b1705326b10d07e" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="配置网桥" ID="3d21705319c5350a5" STYLE="fork">
		<node TEXT="配置docker文件" ID="3c8170532749cb11e" STYLE="fork">
		<node TEXT="vim  /etc/default/docker   在最末尾添加   DOCKER_OPTS=&quot;-b=br0&quot;" ID="de170532773c7184" STYLE="fork">
		</node>
		</node>
		<node TEXT="创建服务依赖文件" ID="16c170532e123b05c" STYLE="fork">
		<node TEXT="mkdir  -p   /etc/systemd/system/docker.service.d" ID="3d0170532e70770a7" STYLE="fork">
		</node>
		<node TEXT="vim /etc/systemd/system/docker.service.d/Using_Environment_File.conf" ID="bd170532eca43133" STYLE="fork">
		<node TEXT="[Service]" ID="2791705330478d0b7" STYLE="fork">
		</node>
		<node TEXT="EnvironmentFile=-/etc/default/docker" ID="11917053318ba906f" STYLE="fork">
		</node>
		<node TEXT="ExecStart=" ID="521705331e06f06e" STYLE="fork">
		</node>
		<node TEXT="ExecStart=/usr/bin/dockerd -H fd:// $DOCKER_OPTS" ID="17d1705331f99f0c4" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="重载服务配置文件" ID="3af1705333cb5509e" STYLE="fork">
		<node TEXT="systemctl  daemon-reload" ID="3811705333efc4156" STYLE="fork">
		</node>
		</node>
		<node TEXT="重启docker" ID="30717053343f9710e" STYLE="fork">
		<node TEXT="ps  aux  |  grep  docker" ID="35e17053349157151" STYLE="fork">
		</node>
		<node TEXT="systemctl  restart  docker" ID="1ef1705334c5c60ab" STYLE="fork">
		</node>
		<node TEXT="ps  aux  |  grep  docker" ID="241705334e8bd00f" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="容器测试" ID="5c170531a666317b" STYLE="fork">
		<node TEXT="创建默认网路的容器" ID="2321705337fa820a" STYLE="fork">
		<node TEXT="docker  run  -itd  --name  nginx-3  nginx" ID="264170533831b10a1" STYLE="fork">
		</node>
		<node TEXT="docker  ps" ID="3cf1705338857806" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看已使用了br0的网卡的网络" ID="30917053392a04058" STYLE="fork">
		<node TEXT="docker  inspect  92d4b5e434d2" ID="8a170533aa79b004" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看网络" ID="dc170533b310203e" STYLE="fork">
		<node TEXT="docker  network  ls" ID="280170533b4c270de" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看网络下的容器" ID="303170533b9cc400c" STYLE="fork">
		<node TEXT="docker  network  inspect  bridge" ID="35f170533bb5aa0d1" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="host模式" ID="6317052ee71bb036" STYLE="fork">
		<node TEXT="简介" ID="1e517052f0f174176" STYLE="fork">
		<node TEXT="容器使用宿主机的ip地址通信，容器与宿主机共享网络" ID="13817052f10b0a05c" STYLE="fork">
		</node>
		<node TEXT="" ID="22817052f198a50ab" STYLE="fork">
		</node>
		</node>
		<node TEXT="命令" ID="2f9170533c7664101" STYLE="fork">
		<node TEXT="格式：docker  run  --net=host  -itd  --name  [容器名称]  镜像名称" ID="6d170533c8fd308b" STYLE="fork">
		</node>
		<node TEXT="实例" ID="254170533d30a90a5" STYLE="fork">
		<node TEXT="docker  network  ls" ID="2fe170533d4b090da" STYLE="fork">
		</node>
		<node TEXT="docker  network  inspect  host  ==>  &quot;Containers&quot;:  {}" ID="319170533d67fd121" STYLE="fork">
		</node>
		<node TEXT="netstat  -tnulp" ID="6f170533de00d0e1" STYLE="fork">
		</node>
		<node TEXT="docker  run  --net=host  -itd  --name  nginx-1  nginx" ID="2cb170533e21f8168" STYLE="fork">
		</node>
		<node TEXT="docker  ps" ID="ee170533ec3ee08f" STYLE="fork">
		</node>
		<node TEXT="netstat  -tunlp" ID="3c2170533ef73e134" STYLE="fork">
		</node>
		<node TEXT="docker network  inspect  host  " ID="1c9170533f2b7d06e" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="container模式" ID="a317052ee7690148" STYLE="fork">
		<node TEXT="简介" ID="17d17052f22287086" STYLE="fork">
		<node TEXT="新建容器间使用，使用已创建的容器网络，类似于一个局域网。特点：容器与容器共享网络" ID="2a717052f22efb091" STYLE="fork">
		</node>
		<node TEXT="" ID="39017052f2be180e4" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="none模式" ID="2d117052ee7a5d099" STYLE="fork">
		<node TEXT="简介" ID="3317052f3273711b" STYLE="fork">
		<node TEXT="不做任何网络配置，容器启动后无网络连接，可最大限度的定制化" ID="2517052f3453e11d" STYLE="fork">
		</node>
		</node>
		<node TEXT="命令" ID="39f17053427f2f01d" STYLE="fork">
		<node TEXT="格式：docker  run  --net=none  -itd  --name  [容器名称]  镜像名称" ID="e417053429bbe173" STYLE="fork">
		</node>
		<node TEXT="实例" ID="1e6170534328cf0ff" STYLE="fork">
		<node TEXT="查看网络：docker  network  ls" ID="32117053433799006" STYLE="fork">
		</node>
		<node TEXT="查看网络none的信息：docker  network  inspect  none" ID="3a6170534370a1122" STYLE="fork">
		</node>
		<node TEXT="根据none网络创建 nginx-2 容器" ID="3991705346c7810cd" STYLE="fork">
		<node TEXT="docker  run  -itd  --name  nginx-2  --net=none  nginx" ID="179170534723bb05a" STYLE="fork">
		</node>
		<node TEXT="docker  ps" ID="26f17053479c49142" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看 nginx-2 的全部信息" ID="841705347bc9914f" STYLE="fork">
		<node TEXT="docker  inspect  nginx-2  发现网络信息皆为空" ID="c11705348155300f" STYLE="fork">
		</node>
		<node TEXT="netstat  -tunlp  发现80端口没有启动" ID="2db17053489c230c1" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="案例" ID="2b17053497dc4071" STYLE="fork">
		<node TEXT="自定义桥接网络" ID="24817053499ca0081" STYLE="fork">
		<node TEXT="1.  网桥软件部署" ID="2d0170534a3f440b3" STYLE="fork">
		<node TEXT="apt-get  install  bridge-utils  -y" ID="33c170534a9bd905f" STYLE="fork">
		</node>
		<node TEXT="brctl  show" ID="155170534ae1cf065" STYLE="fork">
		</node>
		</node>
		<node TEXT="2.  桥接网卡配置" ID="39f170534b0ec9184" STYLE="fork">
		<node TEXT="cp   /etc/network/interfaces   /etc/network/interfaces-old" ID="1df170534b5ac3051" STYLE="fork">
		</node>
		<node TEXT="vim  /etc/network/interfaces" ID="2b9170534bd23109f" STYLE="fork">
		<node TEXT="" ID="71170534c24da114" STYLE="fork">
		</node>
		</node>
		<node TEXT="service  network  restart" ID="255170534cec5d06e" STYLE="fork">
		</node>
		</node>
		<node TEXT="3. docker服务配置" ID="33170534e8b4b0b3" STYLE="fork">
		<node TEXT="配置docker文件" ID="d5170534e911309c1" STYLE="fork">
		<node TEXT="vim /etc/default/docker 在最末尾添加 DOCKER_OPTS=&quot;-b=br0&quot;" ID="63170534e91130f22" STYLE="fork">
		</node>
		</node>
		<node TEXT="创建服务依赖文件" ID="12a170534e91131893" STYLE="fork">
		<node TEXT="mkdir -p /etc/systemd/system/docker.service.d" ID="263170534e91131034" STYLE="fork">
		</node>
		<node TEXT="vim /etc/systemd/system/docker.service.d/Using_Environment_File.conf" ID="28c170534e91130035" STYLE="fork">
		<node TEXT="[Service]" ID="1c5170534e911318b6" STYLE="fork">
		</node>
		<node TEXT="EnvironmentFile=-/etc/default/docker" ID="111170534e91131487" STYLE="fork">
		</node>
		<node TEXT="ExecStart=" ID="c4170534e91130e68" STYLE="fork">
		</node>
		<node TEXT="ExecStart=/usr/bin/dockerd -H fd:// $DOCKER_OPTS" ID="79170534e91130319" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="重载服务配置文件" ID="25c170534e911317f10" STYLE="fork">
		<node TEXT="systemctl daemon-reload" ID="37b170534e911302f11" STYLE="fork">
		</node>
		</node>
		<node TEXT="重启docker" ID="1f8170534e911310312" STYLE="fork">
		<node TEXT="ps aux | grep docker" ID="76170534e911308813" STYLE="fork">
		</node>
		<node TEXT="systemctl restart docker" ID="24b170534e91130ee14" STYLE="fork">
		</node>
		<node TEXT="ps aux | grep docker" ID="320170534e911302415" STYLE="fork">
		</node>
		</node>
		<node TEXT="查看网卡信息" ID="1a0170534fb80917f" STYLE="fork">
		<node TEXT="brctl  show" ID="32d170534fc9a8129" STYLE="fork">
		</node>
		</node>
		<node TEXT="验证dns解析是否正常" ID="29517053504a4d14" STYLE="fork">
		<node TEXT="ping  www.baidu.com" ID="2e1705350873f02a" STYLE="fork">
		</node>
		<node TEXT="vim  /etc/resolv.conf" ID="3b01705350ba77091" STYLE="fork">
		<node TEXT="增加内容" ID="307170535100ba13b" STYLE="fork">
		<node TEXT="nameserver   223.5.5.5" ID="1d5170535121980e4" STYLE="fork">
		</node>
		<node TEXT="nameserver   114.114.114.114" ID="3891705351580915b" STYLE="fork">
		</node>
		<node TEXT="nameserver   8.8.8.8" ID="3531705351815618d" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="/etc/init.d/networking  restart" ID="2f91705351c48503" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="4. 容器创建" ID="14a170535293a705c" STYLE="fork">
		<node TEXT="docker  run  -itd  --net=none  --name  ubuntu-test1  -v  /etc/apt/:/home/etc   ubuntu   /bin/bash" ID="17f17053530fdb172" STYLE="fork">
		</node>
		<node TEXT="docker  ps" ID="1291705353bf0212a" STYLE="fork">
		</node>
		</node>
		<node TEXT="5.  定制容器ip并测试" ID="120170535427f20ee" STYLE="fork">
		<node TEXT="安装pipwork" ID="17417053544f6408e" STYLE="fork">
		<node TEXT="git  clone  http://github.com/jpetazzo/pipework" ID="59170535495680a6" STYLE="fork">
		</node>
		<node TEXT="unzip  pipwork-master.zip" ID="8d17053550b5f17c" STYLE="fork">
		</node>
		<node TEXT="cp  pipwork-master/pipwork  /usr/local/bin/" ID="237170535540d80b7" STYLE="fork">
		</node>
		</node>
		<node TEXT="定制容器ip" ID="3f1705355b61f042" STYLE="fork">
		<node TEXT="pipwork  br0  ubuntu-test1  192.168.110.129/24@192.168.110.2" ID="1871705355de0f132" STYLE="fork">
		</node>
		</node>
		<node TEXT="测试效果" ID="17e1705356993718a" STYLE="fork">
		<node TEXT="docker  exec  -it  ubuntu-test1  /bin/bash" ID="bd1705356b65f0f5" STYLE="fork">
		</node>
		<node TEXT="rm  /etc/apt/sources.list" ID="aa1705357018f14a" STYLE="fork">
		</node>
		<node TEXT="cp  /home/etc/sources.list  /etc/apt/" ID="3201705357878b129" STYLE="fork">
		</node>
		<node TEXT="apt-get  update" ID="1351705357c2f70f7" STYLE="fork">
		</node>
		<node TEXT="apt-get  install  inetutils-ping  -y" ID="3371705357d61b071" STYLE="fork">
		</node>
		<node TEXT="apt-get  install  net-tools  -y" ID="217053580ef1068" STYLE="fork">
		</node>
		<node TEXT="ping  192.168.110.14" ID="14a170535851810b4" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		<node TEXT="跨主机跨容器通信" ID="31e1705360d845113" STYLE="fork">
		<node TEXT="容器网络拓扑图" ID="bb17053615b780ca" STYLE="fork">
		<node TEXT="" ID="fa17053645a0e0ff" STYLE="fork">
		</node>
		<node TEXT="主机信息" ID="2f21705363979f14f" STYLE="fork">
		<node TEXT="主机1： ubuntu   18.04    192.168.8.14" ID="2791705364b260164" STYLE="fork">
		</node>
		<node TEXT="主机2：  Ubuntu  16.04    192.168.8.15" ID="1d9170536519f202b" STYLE="fork">
		</node>
		<node TEXT="均安装  bridge-utils 软件" ID="243170536590c90bd" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="实施" ID="1df17053668223098" STYLE="fork">
		<node TEXT="1. Ubuntu桥接网卡配置" ID="cd17053669fc8041" STYLE="fork">
		<node TEXT="1.1 网桥软件部署" ID="20417053674253163" STYLE="fork">
		<node TEXT="apt-get install bridge-utils -y" ID="41705367475a17e1" STYLE="fork">
		</node>
		<node TEXT="brctl show" ID="1ef1705367475a14a2" STYLE="fork">
		</node>
		</node>
		<node TEXT="1.2 桥接网卡配置" ID="ee1705367475a0af3" STYLE="fork">
		<node TEXT="cp /etc/network/interfaces /etc/network/interfaces-old" ID="2bd1705367475a05f4" STYLE="fork">
		</node>
		<node TEXT="vim /etc/network/interfaces" ID="1da1705367475a1655" STYLE="fork">
		<node TEXT="主机1" ID="3cf1705367475a1496" STYLE="fork">
		<node TEXT="" ID="2bf1705367ca11169" STYLE="fork">
		</node>
		</node>
		<node TEXT="主机2" ID="6c1705367b5d90bb" STYLE="fork">
		<node TEXT="" ID="b41705367d42c091" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="service network restart" ID="32a1705367475a0c67" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="2. docker配置网桥" ID="8d1705369cbaf0bb" STYLE="fork">
		<node TEXT="2.1  配置docker文件" ID="352170536eee420e7" STYLE="fork">
		<node TEXT="" ID="1b2170536f220401e" STYLE="fork">
		</node>
		</node>
		<node TEXT="2.2 创建服务依赖文件" ID="257170536f171f125" STYLE="fork">
		<node TEXT="mkdir -p /etc/systemd/system/docker.service.d" ID="2c81705390a2210731" STYLE="fork">
		</node>
		<node TEXT="vim /etc/systemd/system/docker.service.d/Using_Environment_File.conf" ID="3a31705390a2211592" STYLE="fork">
		<node TEXT="[Service]" ID="3661705390a2210cb3" STYLE="fork">
		</node>
		<node TEXT="EnvironmentFile=-/etc/default/docker" ID="1b51705390a2210334" STYLE="fork">
		</node>
		<node TEXT="ExecStart=" ID="2a41705390a2211415" STYLE="fork">
		</node>
		<node TEXT="ExecStart=/usr/bin/dockerd -H fd:// $DOCKER_OPTS" ID="aa1705390a2211376" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="2.3 重载服务配置文件" ID="1e51705390a22103e7" STYLE="fork">
		<node TEXT="systemctl daemon-reload" ID="3a11705390a2211258" STYLE="fork">
		</node>
		</node>
		<node TEXT="2.4 重启主机 reboot" ID="5d1705390ed7b166" STYLE="fork">
		</node>
		<node TEXT="2.5 验证dns解析是否正常" ID="2e617053911e4e0d9" STYLE="fork">
		<node TEXT="ping&nbsp;www.baidu.com" ID="322170539179360521" STYLE="fork">
		</node>
		<node TEXT="vim /etc/resolv.conf" ID="95170539179360dd2" STYLE="fork">
		<node TEXT="增加内容" ID="168170539179360a83" STYLE="fork">
		<node TEXT="nameserver 223.5.5.5" ID="208170539179361474" STYLE="fork">
		</node>
		<node TEXT="nameserver 114.114.114.114" ID="38f170539179360e65" STYLE="fork">
		</node>
		<node TEXT="nameserver 8.8.8.8" ID="2317053917936136" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="/etc/init.d/networking restart" ID="1c1170539179361937" STYLE="fork">
		</node>
		<node TEXT="brctl  show" ID="1e5170539194e9039" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="3. 容器测试" ID="2db170539994f9097" STYLE="fork">
		<node TEXT="3.1  创建容器" ID="1481705399cf9c143" STYLE="fork">
		<node TEXT="主机1" ID="1c51705399eb590c7" STYLE="fork">
		<node TEXT="docker  run  -itd  --name  ubuntu-test1  -v  /etc/apt/:/home/etc  ubuntu  /bin/bash" ID="241170539a17570dc" STYLE="fork">
		</node>
		<node TEXT="docker  run  -itd  --name  ubuntu-test2  -v  /etc/apt/:/home/etc  ubuntu  /bin/bash" ID="2b4170539a960d18d" STYLE="fork">
		</node>
		</node>
		<node TEXT="主机2" ID="11f170539a06400a6" STYLE="fork">
		<node TEXT="docker  run  -itd  --name  ubuntu-test3  -v  /etc/apt/:/home/etc  ubuntu  /bin/bash" ID="3e4170539ab677036" STYLE="fork">
		</node>
		<node TEXT="docker  run  -itd  --name  ubuntu-test4  -v  /etc/apt/:/home/etc  ubuntu  /bin/bash" ID="2170539abbd712c" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="3.2  容器间测试" ID="ce170539b70fd16" STYLE="fork">
		<node TEXT="主机1" ID="242170539b9190011" STYLE="fork">
		<node TEXT="docker  exec  -it  ubuntu-test1  /bin/bash" ID="146170539bac9a0f" STYLE="fork">
		</node>
		<node TEXT="docker  exec  -it  ubuntu-test2  /bin/bash" ID="34a170539be71a1" STYLE="fork">
		</node>
		</node>
		<node TEXT="主机2" ID="27b170539b9ff717e" STYLE="fork">
		<node TEXT="docker  exec  -it  ubuntu-test3  /bin/bash" ID="392170539c0153057" STYLE="fork">
		</node>
		<node TEXT="docker  exec  -it  ubuntu-test4  /bin/bash" ID="3a3170539c04d604c" STYLE="fork">
		</node>
		</node>
		<node TEXT="互ping测试" ID="197170539c97a809a" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="overlay模式" ID="d317052ee597518f" STYLE="fork">
		<node TEXT="简介" ID="23e17052f45a25003" STYLE="fork">
		<node TEXT="容器彼此不再同一个网络，而且能互相通信" ID="35317052f4645803e" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="Dockerfile" ID="215170539e97c014c" STYLE="bubble" POSITION="left">
		<node TEXT="使用准则" ID="12d1705647d072086" STYLE="fork">
		<node TEXT="尽量将Dockerfile放在空目录中" ID="1891705647eb6d143" STYLE="fork">
		</node>
		<node TEXT="每个容器尽量只有一个功能" ID="c8170564856b501" STYLE="fork">
		</node>
		<node TEXT="执行的命令越少越好" ID="2fb170564880980c9" STYLE="fork">
		</node>
		</node>
		<node TEXT="基础指令详解" ID="1bb1705649f1ec0e8" STYLE="fork">
		<node TEXT="FROM" ID="252170564a1b5408d" STYLE="fork">
		<node TEXT="FROM  <image>" ID="a5170564a85ac106" STYLE="fork">
		</node>
		<node TEXT="FROM  <image>:<tag>" ID="3bf170564aae27131" STYLE="fork">
		</node>
		</node>
		<node TEXT="MAINTAINER" ID="16c170564b374f12" STYLE="fork">
		<node TEXT="MAINTAINER  <name>        指定Dockerfile文件的维护者信息" ID="116170564bac990ab" STYLE="fork">
		</node>
		</node>
		<node TEXT="RUN" ID="19f170564c3216145" STYLE="fork">
		<node TEXT="格式" ID="1db170564c47d018" STYLE="fork">
		<node TEXT="shell 模式             RUN   <command> " ID="231170564cb9c5076" STYLE="fork">
		</node>
		<node TEXT="exec  模式             RUN[&quot;executable&quot;, &quot;param1&quot;, &quot;param2&quot;]" ID="2d3170564d54e7193" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="296170564e0e1a12a" STYLE="fork">
		<node TEXT="表示当前镜像构建时运行的命令，若有确认输入，需加 -y" ID="1a7170564e6bb5047" STYLE="fork">
		</node>
		<node TEXT="若命令教程，结尾处可用  \  来换行" ID="3c9170564f2c920b9" STYLE="fork">
		</node>
		<node TEXT="生产中，推荐使用上面数组的格式" ID="36b170564f80760c6" STYLE="fork">
		</node>
		</node>
		<node TEXT="举例" ID="1a4170564ff5fc143" STYLE="fork">
		<node TEXT="RUN  echo  hello" ID="2ae1705650091f135" STYLE="fork">
		</node>
		<node TEXT="RUN[&quot;echo&quot;,  &quot;hello&quot;]" ID="263170565032000f4" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="CMD" ID="28e170565113aa0d5" STYLE="fork">
		<node TEXT="格式" ID="217056512b43121" STYLE="fork">
		<node TEXT="exec模式             CMD [&quot;executalbe&quot;, &quot;param1&quot;, &quot;param2&quot;]" ID="36617056516e980a5" STYLE="fork">
		</node>
		<node TEXT="shell模式             CMD  command  param1  param2" ID="363170565211300db" STYLE="fork">
		</node>
		<node TEXT="给ENTRYPOINT提供默认参数                CMD  [&quot;param1&quot;, &quot;param2&quot;]" ID="11d170565271dc002" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="1131705651476018f" STYLE="fork">
		<node TEXT="CMD指定容器启动时默认执行的命令" ID="d41705653a37715a" STYLE="fork">
		</node>
		<node TEXT="每个Dockerfile只能由一条CMD命令，若指定多条，仅最后一条会执行" ID="3401705653e469066" STYLE="fork">
		</node>
		<node TEXT="若启动容器时，使用docker  run指定运行命令，则会覆盖CMD" ID="20b170565465f1063" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="11f17056514f0e031" STYLE="fork">
		<node TEXT="CMD [&quot;/usr/sbin/nginx&quot;,  &quot;-g&quot;, &quot;daemon off;&quot;]" ID="4d17056555f2803e" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="ENTRYPOINT" ID="41170565784f300d" STYLE="fork">
		<node TEXT="格式" ID="3171705657a39e14a" STYLE="fork">
		<node TEXT="exec模式            ENTRYPOINT  [&quot;executable&quot;, &quot;param1&quot;, &quot;param2&quot;]" ID="8d1705657ed58035" STYLE="fork">
		</node>
		<node TEXT="shell模式            ENTRYPOINT  command  param1  param2" ID="19917056580658122" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="14f1705657b388084" STYLE="fork">
		<node TEXT="与CMD类似，都是容器启动后执行的命令，且不会被  docker  run 提供的参数覆盖" ID="e017056590afc15c" STYLE="fork">
		</node>
		<node TEXT="每个Dockerfile中只能有一个ENTRYPOINT，当指定多个时，只有最后一个起效" ID="2561705659be6d0f2" STYLE="fork">
		</node>
		<node TEXT="生产中可以同时使用 ENTRYPOINT 和 CMD" ID="33a170565a4130031" STYLE="fork">
		</node>
		<node TEXT="想要在 docker  run时被覆盖，可用  docker  run  --entrypoint  &quot;command&quot;" ID="29170565a992b0c7" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="eb1705657c43c0f5" STYLE="fork">
		<node TEXT="ENTRYPOINT  [&quot;/usr/sbin/nginx&quot;, &quot;-g&quot;, &quot;daemon off&quot;]" ID="1b917056658ebf088" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="CMD &amp; ENTRYPOINT 综合使用" ID="2781705667c20101c" STYLE="fork">
		<node TEXT="ENTRYPOINT   [&quot;/usr/sbin/nginx&quot;]" ID="3101705667fcfe0a" STYLE="fork">
		</node>
		<node TEXT="CMD  [&quot;-g&quot;]" ID="4a1705668787b05c" STYLE="fork">
		</node>
		<node TEXT="docker  run  --name  nginx-7  -d  nginx  -g &quot;daemon off;&quot;" ID="1941705668b7b603a" STYLE="fork">
		</node>
		</node>
		<node TEXT="ADD" ID="19317056bf2c9711d" STYLE="fork">
		<node TEXT="格式" ID="18317056bf40440ae" STYLE="fork">
		<node TEXT="ADD  <src> ...   <dest>" ID="14617056bf895c016" STYLE="fork">
		</node>
		<node TEXT="ADD  [&quot;<src>&quot;, ...  ,&quot;<dest>&quot;]" ID="12a17056bfe63b14c" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="10217056bf5cc8169" STYLE="fork">
		<node TEXT="将宿主机上指定的src文件复制到容器中的dest" ID="32a17056c0750d166" STYLE="fork">
		</node>
		<node TEXT="所有拷贝到container中的文件和文件夹权限均为0755，uid和gid为0" ID="28e17056c104f002d" STYLE="fork">
		</node>
		<node TEXT="若文件是可识别的压缩格式，docker会帮忙解压缩" ID="1d717056c1811007f" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="35217056bf6d6e146" STYLE="fork">
		<node TEXT="ADD  [&quot;sources.list&quot;,  &quot;/etc/apt/sources.list&quot;]" ID="18317056c318f80af" STYLE="fork">
		</node>
		<node TEXT="ADD  [&quot;linshi.tar.gz&quot;,  &quot;/nihao/&quot;]" ID="2f17056c3b14e0f5" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="COPY" ID="cc17056c4ad1a13d" STYLE="fork">
		<node TEXT="格式" ID="1c117056c4bac700e" STYLE="fork">
		<node TEXT="COPY  <src>...  <dest>" ID="3bf17056c4e64707" STYLE="fork">
		</node>
		<node TEXT="COPY  [&quot;<src>&quot;,...,  &quot;<dest>&quot;]" ID="3ab17056c517e60ee" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="9f17056c4c8ce16" STYLE="fork">
		<node TEXT="与ADD功能和使用方式类似，但不会做自动解压工作" ID="1e917056c59dbb181" STYLE="fork">
		</node>
		<node TEXT="单纯复制文件场景，推荐用COPY" ID="3617056c600fa10b" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="7717056c4d0290ac" STYLE="fork">
		<node TEXT="COPY  [&quot;index.html&quot;, &quot;/var/www/html/&quot;]" ID="1f717056c65800011" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="VOLUME" ID="2ca17056c72ec10dd" STYLE="fork">
		<node TEXT="格式" ID="28617056c747b118e" STYLE="fork">
		<node TEXT="VOLUME  [&quot;/data&quot;]" ID="31417056c78a32063" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="1c017056c759b80a8" STYLE="fork">
		<node TEXT="VOLUME指令可在镜像中创建挂载点，只要通过该镜像创建的容器都有挂载点" ID="39517056c7dadc193" STYLE="fork">
		</node>
		<node TEXT="通过VOLUME指令创建的挂载点，无法指定主机上对应的目录，是自动生成的" ID="13417056c88cfb0fd" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="2d817056c764040e8" STYLE="fork">
		<node TEXT="VOLUME  [&quot;/var/lib/tomcat7/webapps/&quot;]" ID="27117056c903640c8" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="ENV" ID="6217056c9e9760a3" STYLE="fork">
		<node TEXT="格式" ID="37017056ca002a01d" STYLE="fork">
		<node TEXT="ENV   <key>   <value>" ID="37917056ca33a215f" STYLE="fork">
		</node>
		<node TEXT="ENV   <key>=<value>  ..." ID="39917056ca68c00b1" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="32e17056ca1e260a" STYLE="fork">
		<node TEXT="设置环境变量，可在RUN之前使用，在RUN命令时调用，容器启动时这些环境变量都会被指定" ID="12517056caaba414f" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="31117056ca2458188" STYLE="fork">
		<node TEXT="ENV  NIHAO=helloworld" ID="a717056cb8b2d118" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="WORKDIR" ID="13717056cc2a810c4" STYLE="fork">
		<node TEXT="格式" ID="4017056cc625c0c9" STYLE="fork">
		<node TEXT="WORKDIR   /path/to/workdir" ID="38517056cc8aa3119" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="a817056cc6d39124" STYLE="fork">
		<node TEXT="切换目录，为后续的 RUN、CMD、ENTRYPOINT  指令配置工作目录，相当于  cd" ID="1cd17056ccd2dc0d2" STYLE="fork">
		</node>
		<node TEXT="可以多次切换（相当于cd命令）" ID="32a17056cd6690015" STYLE="fork">
		</node>
		<node TEXT="可使用多个WORKDIR指令，后续指令若参数是相对路径，则是基于之前指令的路径" ID="4617056cd952f185" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="3d17056cc73ef0e4" STYLE="fork">
		<node TEXT="WORKDIR   /a" ID="d117056ce228a07b" STYLE="fork">
		</node>
		<node TEXT="WORKDIR   b" ID="27117056ce40de147" STYLE="fork">
		</node>
		<node TEXT="RUN   pwd" ID="1a717056ce5b210b3" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="ONBUILD" ID="f717056cf0732025" STYLE="fork">
		<node TEXT="格式" ID="16017056cf27d001d" STYLE="fork">
		<node TEXT="ONBUILD  [command]" ID="15317057065e9b0fc" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="1ba17056cf348f07c" STYLE="fork">
		<node TEXT="当一个镜像A被作为其他镜像B的基础镜像时，这个触发器才会被执行" ID="3ac1705706928f095" STYLE="fork">
		</node>
		<node TEXT="新镜像B在构建的时候，会插入触发器中的指令" ID="20b170570706790fd" STYLE="fork">
		</node>
		</node>
		<node TEXT="实例" ID="30217056cf3ef8141" STYLE="fork">
		<node TEXT="ONBUILD   COPY   [&quot;index.html&quot;, &quot;/var/www/html/&quot;]" ID="1931705707e12016d" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="USER" ID="54170570b8b1817b" STYLE="fork">
		<node TEXT="格式" ID="10c170570b9a62152" STYLE="fork">
		<node TEXT="USER  daemon" ID="75170570bf53215e" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="32f170570ba79c09e" STYLE="fork">
		<node TEXT="指定运行容器时的用户名和UID，后续的RUN指令也会使用这里指定的用户" ID="385170570c1b9f0da" STYLE="fork">
		</node>
		<node TEXT="若不输入任何信息，表示默认使用 root 用户" ID="103170570c8b7c063" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="ARG" ID="1aa170570bdb69141" STYLE="fork">
		<node TEXT="格式" ID="301170570cd68a116" STYLE="fork">
		<node TEXT="ARG  <name>  [=<default  value>]" ID="14a170570cf37006e" STYLE="fork">
		</node>
		</node>
		<node TEXT="解释" ID="23a170570ce81e094" STYLE="fork">
		<node TEXT="ARG 指定了一个变量在  docker  build 的时候使用，可以使用 --build-arg  <varname>=<value> 来指定参数的值" ID="58170570d5f34184" STYLE="fork">
		</node>
		<node TEXT="若构建时不指定就会报错" ID="3a9170570e89b9043" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="EXPOSE" ID="33217056509c940c1" STYLE="fork">
		</node>
		</node>
		<node TEXT="构建缓存" ID="ee17057093f3616d" STYLE="fork">
		<node TEXT="第一次构建很慢，之后构建会很快，因为他们用到了构建的缓存" ID="3ba17057098e3710a" STYLE="fork">
		</node>
		<node TEXT="取消缓存" ID="2bb170570a18d6084" STYLE="fork">
		<node TEXT="docker  build  --no-cache  -t  [镜像名]:[镜像版本]  [Dockerfile位置]" ID="167170570a2e9d05a" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
</node>
</map>