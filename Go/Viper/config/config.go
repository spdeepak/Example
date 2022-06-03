package config

import (
	"github.com/fsnotify/fsnotify"
	"github.com/spf13/viper"
)

type AppConfig struct {
	v        *viper.Viper
	Name     string `required:"true" yaml:"name"`
	Username string `required:"true" yaml:"username"`
	Password string `required:"true" yaml:"password"`
}

type secret struct {
	v        *viper.Viper
	Username string `required:"true" json:"username"`
	Password string `required:"true" json:"password"`
}

func (c *AppConfig) readAppConfig() {
	v := viper.New()

	v.SetTypeByDefaultValue(true)
	v.SetConfigName("application")
	v.SetConfigType("yml")
	v.AddConfigPath("./configs")
	//v.SetConfigFile(os.Getenv("CONFIG_FILE_PATH"))
	c.v = v

	if err := v.ReadInConfig(); err != nil {
		panic(err)
	}

	if err := v.Unmarshal(c); err != nil {
		panic(err)
	}
}

func (s *secret) readSecret() {
	v := viper.New()

	v.SetTypeByDefaultValue(true)
	v.SetConfigName("secret")
	v.SetConfigType("json")
	v.AddConfigPath("./configs")
	//v.SetConfigFile(os.Getenv("SECRETS_FILE_PATH"))
	s.v = v

	if err := v.ReadInConfig(); err != nil {
		panic(err)
	}

	if err := v.Unmarshal(s); err != nil {
		panic(err)
	}
}

func NewConfiguration() *AppConfig {
	applicationConfig := &AppConfig{}
	applicationConfig.readAppConfig()
	applicationConfig.v.WatchConfig()
	applicationConfig.v.OnConfigChange(func(in fsnotify.Event) {
		applicationConfig.readAppConfig()
	})

	secret := &secret{}
	secret.readSecret()
	secret.v.WatchConfig()
	secret.v.OnConfigChange(func(in fsnotify.Event) {
		secret.readSecret()
	})

	applicationConfig.Username = secret.Username
	applicationConfig.Password = secret.Password
	return applicationConfig
}
