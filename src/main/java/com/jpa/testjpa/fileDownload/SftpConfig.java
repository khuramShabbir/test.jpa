//package com.jpa.testjpa.fileDownload;
//
//import jakarta.annotation.Resource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.File;
//
//@Configuration
//public class SftpConfig {
//
//    @Value("${sftp.host}")
//    private String sftpHost;
//
//    @Value("${sftp.port:22}")
//    private int sftpPort;
//
//    @Value("${sftp.user}")
//    private String sftpUser;
//
//    @Value("${sftp.privateKey:#{null}}")
//    private Resource sftpPrivateKey;
//
//    @Value("${sftp.privateKeyPassphrase:}")
//    private String sftpPrivateKeyPassphrase;
//
//    @Value("${sftp.password:#{null}}")
//    private String sftpPasword;
//
//    @Value("${sftp.remote.directory:/}")
//    private String sftpRemoteDirectory;
//
//    @Bean
//    public SessionFactory<LsEntry> sftpSessionFactory() {
//        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
//        factory.setHost(sftpHost);
//        factory.setPort(sftpPort);
//        factory.setUser(sftpUser);
//        if (sftpPrivateKey != null) {
//            factory.setPrivateKey(sftpPrivateKey);
//            factory.setPrivateKeyPassphrase(sftpPrivateKeyPassphrase);
//        } else {
//            factory.setPassword(sftpPasword);
//        }
//        factory.setAllowUnknownKeys(true);
//        return new CachingSessionFactory<LsEntry>(factory);
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "toSftpChannel")
//    public MessageHandler handler() {
//        SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory());
//        handler.setRemoteDirectoryExpression(new LiteralExpression(sftpRemoteDirectory));
//        handler.setFileNameGenerator(new FileNameGenerator() {
//            @Override
//            public String generateFileName(Message<?> message) {
//                if (message.getPayload() instanceof File) {
//                    return ((File) message.getPayload()).getName();
//                } else {
//                    throw new IllegalArgumentException("File expected as payload.");
//                }
//            }
//        });
//        return handler;
//    }
//
//    @MessagingGateway
//    public interface UploadGateway {
//
//        @Gateway(requestChannel = "toSftpChannel")
//        void upload(File file);
//
//    }
//}