package com.solarexsoft.practice

/**
 * Created by Solarex on 3/3/21/2:52 PM
 * Desc:
 */
sealed class PracticeFeedRsp<out Feed: PracticeFeed<out PracticeFeedRsp<Feed>>>(
    val feedFrameId: String
) {
    class Video(
            feedFrameId: String,
            val videoSectionId: String = ""
    ): PracticeFeedRsp<PracticeFeed.Video>(feedFrameId)

    class WordReview(
            feedFrameId: String,
            val reviewType: String
    ): PracticeFeedRsp<PracticeFeed.WordReview>(feedFrameId)

    class ListenReview(
            feedFrameId: String,
            val listenType: String
    ): PracticeFeedRsp<PracticeFeed.ListenReview>(feedFrameId)
}

sealed class PracticeFeed<RSP: PracticeFeedRsp<PracticeFeed<RSP>>>(
    val rsp: RSP,
    val scene: String
) {
    open class Question<FeedRsp: PracticeFeedRsp<PracticeFeed<FeedRsp>>>(
            rsp: FeedRsp,
            scene: String
    ): PracticeFeed<FeedRsp>(rsp, scene)

    class Video(
            rsp: PracticeFeedRsp.Video,
            scene: String
    ): Question<PracticeFeedRsp.Video>(rsp, scene)

    class WordReview(
            rsp: PracticeFeedRsp.WordReview,
            scene: String
    ): Question<PracticeFeedRsp.WordReview>(rsp, scene)

    class ListenReview(
            rsp: PracticeFeedRsp.ListenReview,
            scene: String
    ): Question<PracticeFeedRsp.ListenReview>(rsp, scene)
}