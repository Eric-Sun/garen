package com.j13.v2.server.vos;

import com.google.common.collect.Lists;
import com.j13.v2.server.poppy.anno.Parameter;

import java.util.List;

public class CommentResp {
    @Parameter(desc = "评论id")
    private int cid;
    @Parameter(desc="评论的内容")
    private String content;
    @Parameter(desc="创建评论的时间戳")
    private long createTime;
    @Parameter(desc="用户id")
    private int userId;
    @Parameter(desc="用户名")
    private String userName;
    @Parameter(desc="用户头像")
    private String userImg;
    @Parameter(desc="此条评论点赞的数量")
    private int praiseCount;
    @Parameter(desc="此条评论分享的次数")
    private int shareCount;
    @Parameter(desc="此条评论的回复评论的数量")
    private int commentCount;
    @Parameter(desc="回复此评论的评论数量")
    private List<CommentReplyResp> replys = Lists.newLinkedList();

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<CommentReplyResp> getReplys() {
        return replys;
    }

    public void setReplys(List<CommentReplyResp> replys) {
        this.replys = replys;
    }
}
