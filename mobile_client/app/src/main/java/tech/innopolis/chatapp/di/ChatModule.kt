package tech.innopolis.chatapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import tech.innopolis.chatapp.data.repository.ChatRepositoryImpl
import tech.innopolis.chatapp.domain.ChatApi
import tech.innopolis.chatapp.domain.repository.ChatRepository
import javax.inject.Singleton


private const val BASE_URL = "http://localhost:8080//messages/"

@Module
@InstallIn(SingletonComponent::class)
class ChatModule {

    @Provides
    @Singleton
    fun provideChatApi(): ChatApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
            .create(ChatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChatRepository(api: ChatApi): ChatRepository{
        return ChatRepositoryImpl(api)
    }
}