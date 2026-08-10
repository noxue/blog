---
title: "网络环境自查"
linkTitle: "网络环境自查"
subtitle: "注册海外账号前先看一眼 IP、时区、语言对不对得上"
description: "一键检查出口 IP 归属地、系统时区、浏览器语言是否一致，以及 WebRTC 是否泄露真实 IP。"
date: 2026-08-10
draft: false
author: "noxue"
tags: ["网络", "IP", "海外账号", "风控", "小工具"]
categories: ["小工具"]
weight: 2
math: false
lightgallery: false
toc: false
---

注册 Google、Apple ID、交易所这类海外账号时，最常见的翻车原因不是没有节点，而是**你的 IP 在美国、系统时区却是北京、浏览器语言还是中文**。风控系统一看就知道有问题。

<!--more-->

{{< tool-netcheck >}}

## 三项对不上怎么改

| 项目 | 怎么改 |
| --- | --- |
| **IP 归属地** | 换节点。优先选住宅 IP（原生 IP），机房 IP 容易被判定为代理 |
| **系统时区** | Windows：设置 → 时间和语言 → 日期和时间 · macOS：系统设置 → 通用 → 日期与时间 · iOS：设置 → 通用 → 日期与时间 |
| **浏览器语言** | Chrome：设置 → 语言 → 把目标语言拖到第一位 · Safari 跟随系统语言 |

{{< admonition type="tip" title="更省事的做法" open=true >}}
不想改自己电脑的系统设置，就用一个干净的浏览器配置文件（Chrome 新建用户）或指纹浏览器专门跑海外账号，时区和语言只在那个环境里改。
{{< /admonition >}}

## 关于 WebRTC 泄露

WebRTC 是浏览器做音视频通话用的，它会绕过 HTTP 代理直接探测你的网络地址。如果上面检测出了和出口 IP 不一样的公网地址，说明代理只代理了普通流量，真实位置还是会漏出去。

- Chrome：装 WebRTC Leak Prevent 之类的扩展，或用 TUN / 全局模式代理
- Safari：设置 → 高级 → 开启「显示网页开发者功能」→ 开发 → WebRTC → 关闭 ICE 候选限制之外的选项
- 最彻底的办法是让代理工作在 TUN（虚拟网卡）模式，所有流量都走代理
