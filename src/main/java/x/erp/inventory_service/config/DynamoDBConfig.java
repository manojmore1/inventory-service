package x.erp.inventory_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


@Configuration
public class DynamoDBConfig {

//    @Value("${aws.accessKeyId}")
//    private String awsAccessKey;
//
//    @Value("${aws.secretKey}")
//    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;


     @Bean
    public DynamoDbClient dynamoDbClient() {
//        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(awsAccessKey, awsSecretKey);

         // Use DefaultAWSCredentialsProviderChain to get credentials
         DefaultCredentialsProvider credentialsProvider = DefaultCredentialsProvider.create();

        return DynamoDbClient.builder()
                .region(Region.AP_SOUTH_1) // Set your desired region
//                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .credentialsProvider(credentialsProvider)
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    // @Bean
    // public AmazonDynamoDB amazonDynamoDB() {
    //     return AmazonDynamoDBClientBuilder.standard()
    //         .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
    //         .withRegion(awsRegion)
    //         .build();
    // }

    // // Other beans and configurations...

    // @Bean
    // @Primary
    // public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
    //     return new DynamoDBMapper(amazonDynamoDB);
    // }
}