---
title: "绿色种子播放器：磁力/种子边下边播，内置视频与图片，Win/Mac 免安装"
subtitle: "任意磁力·种子·m3u8 一边下一边看，桌面小工具，绿色单文件"
date: 2026-08-18T20:30:00+08:00
draft: false
author: "noxue"
tags: ["种子", "磁力", "BitTorrent", "播放器", "绿色软件"]
categories: ["小工具"]
featuredImage: "cover.png"
math: false
lightgallery: true
---

网页版的 [种子/磁力解析](https://tools.noxue.com/torrent/) 能在浏览器里预览，但受限于 WebTorrent，只有少数带 WebRTC 的种子能播。想让**任意磁力/种子都能边下边播**、还能**在软件里直接看视频和图片**，就用这个**桌面绿色小工具**——单文件、免安装，Windows / macOS 都能跑。

<!--more-->

## 它能做什么

- **多来源**：磁力链接 `magnet:`、`.torrent` 文件、直链、`m3u8`，还有迅雷 `thunder://` / 快车 `flashget://` / QQ旋风 `qqdl://` 专用链（自动还原）。
- **边下边播**：内置本地流媒体，点哪个文件看哪个，拖动进度条即时跳转，不必等下载完。
- **两种模式**：「边下边播」或「只下载」。
- **内置查看**：图片在软件里直接看；视频用**窗口内置播放器**播放（启用 mpv 后）。
- **可设保存目录**，默认 `下载/noxue-torrent`。
- **绿色免安装**：一个可执行文件，约 14 MB，拷了就能用。

{{< admonition type="warning" title="合规提醒" open=true >}}
本工具只是个下载/播放器，请遵守当地法律与版权规定，只下载你有合法权利获取的内容。
{{< /admonition >}}

## 怎么用（三步）

1. **粘贴链接**：把磁力链接 / 种子路径 / 直链 / m3u8 粘到输入框，点「添加 / 播放」；或点「选 .torrent」直接选种子文件。
2. **选模式和目录**（可选）：上方切「边下边播 / 只下载」，点「更改目录」设保存位置。
3. **看内容**：下方文件列表里，图片点「查看」在软件内浏览，视频/音频点「播放」——启用内置播放时直接在窗口里放，可暂停、±10 秒跳转。

## 下载与运行

### macOS
下载后，因为是未签名的绿色程序，首次运行需要放行一下：

```bash
# 终端里去掉隔离属性后即可双击/运行
xattr -d com.apple.quarantine ./noxue-torrent-player
./noxue-torrent-player
```

### Windows
下载 `noxue-torrent-player.exe`，双击即可（SmartScreen 提示时选「仍要运行」）。

{{< admonition type="tip" title="想要窗口内置视频播放" open=true >}}
默认版本里，图片是内置查看，视频会用系统默认播放器打开（不走浏览器）。若要**在软件窗口里直接播放视频**（边下边播、可拖动），用带 `mpv` 的版本——它需要系统里有 **libmpv**：

- **macOS**：`brew install mpv`
- **Windows**：安装 mpv（含 `libmpv` / `mpv-2.dll`）
- **Linux**：`sudo apt install libmpv-dev mpv`

绿色发布时把 libmpv 动态库和程序放一起即可。
{{< /admonition >}}

## 从源码构建（开发者）

工具用 **Rust + librqbit + Slint** 写成，编译出单个可执行文件：

```bash
# 需要 Rust（https://rustup.rs）
git clone <仓库地址> && cd noxue-torrent-player
cargo run                        # 直接运行
cargo run -- "magnet:?xt=..."    # 启动即添加链接
cargo build --release            # 出绿色单文件（target/release/）

# 窗口内置视频播放（需 libmpv）：
cargo build --release --features mpv
```

## 搭配网页版

临时在别人电脑上、或只想快速看一眼？用免安装的 [网页版种子/磁力解析](https://tools.noxue.com/torrent/)：看清链接里有什么、浏览器里预览（支持 WebRTC 的种子）。要长期用、要任意种子边下边播，就用这个桌面绿色版。

工具页：**[https://tools.noxue.com/torrent/](https://tools.noxue.com/torrent/)**
