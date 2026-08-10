---
title: "图片压缩 / 转 WebP"
linkTitle: "图片压缩"
subtitle: "本地批量压缩改尺寸，不上传服务器"
description: "在浏览器本地批量压缩图片、限制最大宽度并转成 WebP / JPEG / PNG，图片不会上传到任何服务器。"
date: 2026-08-10
draft: false
author: "noxue"
tags: ["图片", "压缩", "WebP", "小工具"]
categories: ["小工具"]
weight: 5
math: false
lightgallery: false
toc: false
---

写文章配图、发朋友圈、上传证件照之前先压一下。所有处理都在你自己的浏览器里完成，**图片不会上传到任何服务器**。

<!--more-->

{{< tool-image >}}

## 参数怎么选

| 场景 | 最大宽度 | 格式 | 质量 |
| --- | --- | --- | --- |
| 博客 / 网页配图 | 1200 ~ 1600 | WebP | 75 ~ 85 |
| 微信公众号 | 1080 | JPEG | 80 |
| 需要透明背景 | 按需 | PNG 或 WebP | — |
| 截图存档 | 原图宽度 | PNG | — |

{{< admonition type="info" title="为什么选 WebP" open=false >}}
同样画质下 WebP 比 JPEG 小 25% ~ 35%，现在 Safari、Chrome、微信内置浏览器都支持。只有非常老的设备才需要退回 JPEG。

另外 JPEG 不支持透明，带透明背景的图转成 JPEG 时透明区域会被填成白色。
{{< /admonition >}}
