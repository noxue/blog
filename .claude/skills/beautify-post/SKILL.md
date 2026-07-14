---
name: beautify-post
description: 美化本 Hugo + DoIt 博客文章的排版呈现（不改文字内容）。当用户说「美化排版 / 调整排版 / 优化文章样式 / 让文章更好看 / 帮我排版一下 / 图片加 alt / 图片能点击放大 / 加提示框」等针对 content/ 下某篇文章的呈现优化时使用。默认只调整呈现（链接、图片 alt/放大/懒加载、提示框、标题层级、空行），不改动正文文字，除非用户明确要求增删内容。
---

# 美化 DoIt 博客文章排版

对 `content/posts/**/index.md`(或单文件文章)做**呈现层美化**。核心原则:**默认不改正文文字**,只调整 Markdown 结构与主题特性的用法。用户明确要求增删/改写内容时才动文字。

## 适用前提

- 本项目是 Hugo + DoIt 主题(`themes/DoIt`),配置在 `config/_default/`。
- 改完必须用 `hugo --quiet` 验证无 error;本地若开着 `hugo server` 会自动热更新。

## 本主题已确认的渲染行为(据此决定怎么写 Markdown)

这些是读过 `themes/DoIt/layouts/_markup/render-*.html` 和 `_partials/plugin/{link,image}.html` 得出的结论,直接照用,不用重新调研:

1. **外部链接自动新标签打开**:`_partials/plugin/link.html` 对有 host 的链接自动加 `target="_blank" rel="noopener noreferrer"`。
   - ⇒ 只要把裸链接补成带协议的绝对 URL(`www.x.com` → `https://www.x.com`),就会外部打开。无需手写 HTML。
2. **图片自动懒加载**:`render-image.html` 对所有图片强制 `loading="lazy"`。无需手动处理。
3. **图片点击放大 = 必须带 title(图注)**:`render-image.html` 只有当 Markdown 图片**带 title** 时才走 `<figure>` 分支并接入 lightgallery(`class="lightgallery"` 锚点),空 `![]()` 内联图**不可放大**。
   - ⇒ 想要放大,就得写成 `![alt](src "图注")`。放大与图注是绑定的,有图注才有放大。
4. **alt 来源**:`<img alt>` 取自 Markdown 方括号里的文字(`![这里](...)`)。图注(figcaption)取自双引号 title。
5. 页面/全局需 `lightgallery: true`(front matter 或 `config/_default/params.toml`),本项目默认已开。

## 美化清单(逐项应用)

### 1. 图片:alt + 图注 + 放大 + 懒加载
把每张 `![](xxx.png)` 改成:
```markdown
![具体的中文 alt 描述，说明这张截图/配图是什么](xxx.png "简短图注")
```
- alt 要**具体**(利于无障碍与 SEO),描述图片内容而非「图片1」。
- 图注简短(会显示在图下方)。
- 这样一步同时得到:alt、点击放大、图注、懒加载(懒加载自动)。
- ⚠️ 若用户明确说**不要图注**:则无法同时保留点击放大(主题限制),需向用户说明并让其二选一。

### 2. 链接:补全协议 → 自动外部打开
裸链接 / 缺协议的补成 `https://…`。已带协议的保持不动。文字(锚文本)不要改。

### 3. 重点提醒 → admonition 提示框
把正文里「注意 / 千万 / 一定要 / 建议 / 必须」这类**关键提醒句**包成提示框,**文字原样保留**:
```markdown
{{< admonition type="warning" title="注意" open=true >}}
原文提醒句照抄
{{< /admonition >}}
```
类型选择:
- `danger` — 不可逆/严重后果(如「填错就找不回」)
- `warning` — 硬性约束(如「必须国外手机号」)
- `tip` — 操作小技巧(如「生日填成年」)
- `info` / `note` — 一般补充说明
- `abstract` — 章节开头的「准备工作 / 前置条件」清单,让其更醒目

不要滥用:只包真正的关键点,普通陈述句保持普通段落。

### 4. 章节/清单醒目化
「准备工作」「前置条件」这类清单,可从裸列表升级为 `abstract` 提示框,配一句醒目标题,使其在长文里跳出来。

### 5. 结构清理
- 统一标题层级:正文各步骤同级(一般用 `##`),正文里不要出现 `#`(H1 留给文章标题)。
- 清理连续多个空行为单个空行。
- 不改动任何标题文字与正文措辞。

## 完成后必做

1. `cd` 到项目根,跑 `hugo --quiet` 确认无 error(尤其 admonition/shortcode 语法)。
2. 抽查渲染产物 `public/<文章路径>/index.html`,确认:
   - `class="lightgallery"` 数量 == 图片数(可放大)
   - `loading="lazy"` 数量 == 图片数(懒加载)
   - `target="_blank"` 覆盖所有外链
   - 截图的中文 alt 已出现
3. 向用户汇报改了哪些项,并**询问是否提交发布**(部署见项目 README / 记忆 noxue-blog-ops:走 `git push origin main`,SSH 别名 `github-noxue`,GitHub Actions 自动部署)。

## 边界

- 默认**只碰呈现**,不增删改正文文字。用户要求改内容时另说。
- 不动 front matter 里用户已设的值(除非该项正是要调的,如加 `featuredImage`)。
- 拿不准某句是否算「重点提醒」时,倾向保守(保持普通段落),或问用户。
