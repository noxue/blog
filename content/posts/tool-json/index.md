---
title: "在线 JSON 工具：格式化、压缩、校验，还有可折叠树状图"
subtitle: "语法高亮 + 出错定位行列，内容本地缓存"
date: 2026-08-11T08:18:00+08:00
draft: false
author: "noxue"
tags: ["JSON", "格式化", "开发工具"]
categories: ["小工具"]
featuredImage: "cover.png"
math: false
lightgallery: true
---

接口返回一坨压扁的 JSON，想格式化看清结构、或者反过来压成一行？**不学网工具箱** 的 [JSON 工具](https://tools.noxue.com/json/) 格式化、压缩、校验都有，还给一个可折叠的树状图，出错还会标出行列位置。

<!--more-->

## 能做什么

- **格式化 / 压缩**：一键美化缩进，或压成一行；缩进大小可选，还能按 key 排序。
- **校验 + 错误定位**：JSON 不合法时，标出**具体第几行第几列**出错。
- **可折叠树状图**：把 JSON 画成带语法高亮的树，长对象点一下折叠/展开。
- **字符串转义 / 还原**：处理那种「JSON 里套了一段字符串 JSON」的场景。
- **本地缓存**：内容存在浏览器本地，刷新不丢，不上传。

## 第一步：粘 JSON

把 JSON 粘进输入框（没有就点「填个示例」）。上面选「格式化 / 压缩」等模式和缩进。

![JSON 工具的输入区：格式化/压缩模式、缩进选择，以及带语法高亮的 JSON 输入框](step1-input.png "① 粘上 JSON，选模式和缩进")

{{< admonition type="tip" title="报错会告诉你在哪" open=true >}}
JSON 有语法错误时，工具会标出出错的行列位置，比浏览器控制台那句笼统的报错好定位多了。
{{< /admonition >}}

## 第二步：看结果和树状图

下面给出格式化/压缩后的结果，还有一个**可折叠树状图**——对象、数组、字符串、数字用不同颜色标出，点三角形折叠长节点。

![JSON 树状图：根对象展开显示 name/version/tags 等字段，不同类型不同颜色，可折叠](step2-output.png "② 可折叠树状图，结构一目了然")

工具地址：**[https://tools.noxue.com/json/](https://tools.noxue.com/json/)** ，纯前端，数据不上传。
