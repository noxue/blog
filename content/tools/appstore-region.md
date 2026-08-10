---
title: "App Store 换区跳转工具"
linkTitle: "App Store 换区"
subtitle: "一键唤起 App Store 切到指定国家 / 地区"
description: "在 Safari 中点击即可唤起 App Store 切换到美区、日区、港区等 177 个国家和地区，支持关键词搜索。"
date: 2026-08-10
draft: false
author: "noxue"
tags: ["App Store", "换区", "小工具", "iOS"]
categories: ["小工具"]
weight: 1
math: false
lightgallery: false
toc: false
---

点下面任意国家 / 地区，就会唤起 App Store 并发起切换请求。**必须在 Safari 中打开本页面**，微信、QQ 等 App 内置浏览器点了不会有反应。

<!--more-->

{{< appstore-region >}}

## 使用说明

{{< admonition type="warning" title="点之前先看这两条" open=true >}}
1. **必须用 Safari。** 只有 iPhone / iPad / Mac 上的 Safari 能唤起 `itms-apps://` 链接。在微信里打开的话，点右上角「···」→「在 Safari 中打开」。
2. **这是非官方接口。** 新版 iOS 上它通常只切换「你正在浏览的商店前端」，付费下载仍受账号实际归属地区限制。要**真正**把账号改到别的国家，见下面的正规入口。
{{< /admonition >}}

## 真正修改账号所属国家 / 地区

改区前需要满足 Apple 的三个前提条件：

- 用完 Apple 账户余额（余额必须为 0）
- 取消所有订阅，并等到当前订阅周期结束
- 准备好新地区可用的付款方式或地址

然后任选一条路径：

| 方式 | 路径 |
| --- | --- |
| 网页（推荐） | [account.apple.com](https://account.apple.com) → 个人信息 → 国家或地区 |
| iPhone / iPad | 设置 → Apple 账户 → 媒体与购买项目 → 查看账户 → 国家 / 地区 |
| Mac | App Store → 左下角点自己的名字 → 账户设置 → 更改国家或地区 |

## 只想看看别的区有什么 App

不用切区，直接在 App 链接里换掉地区代码就行：

```text
https://apps.apple.com/us/app/<名称>/id<应用ID>    美区
https://apps.apple.com/jp/app/<名称>/id<应用ID>    日区
https://apps.apple.com/hk/app/<名称>/id<应用ID>    港区
```

## 本工具用的链接长什么样

```text
itms-apps://itunes.apple.com/WebObjects/MZStore.woa/wa/resetAndRedirect?cc=us&dsf=143441
```

`cc` 是两位国家代码，`dsf` 是 Apple 的 storefront ID。想自己拼链接的话，把这两个值换成目标地区的即可，本页面已经内置了全部 177 个地区的对应关系。
