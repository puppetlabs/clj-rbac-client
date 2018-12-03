(defn deploy-info
  [url]
  {:url url
   :username :env/clojars_jenkins_username
   :password :env/clojars_jenkins_password
   :sign-releases false})

(defproject puppetlabs/rbac-client "0.9.3-SNAPSHOT"
  :description "Tools for interacting with PE RBAC"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}

  :parent-project {:coords [puppetlabs/clj-parent "2.3.4"]
                   :inherit [:managed-dependencies]}

  :dependencies [[org.clojure/clojure]
                 [ring/ring-core]
                 [ring/ring-json]
                 [puppetlabs/ring-middleware]
                 [slingshot]
                 [puppetlabs/kitchensink]
                 [puppetlabs/http-client]
                 [puppetlabs/trapperkeeper]
                 [puppetlabs/i18n]]

  :pedantic? :abort
  :profiles {:dev {:dependencies [[puppetlabs/kitchensink :classifier "test"]
                                  [puppetlabs/trapperkeeper :classifier "test"]
                                  [puppetlabs/trapperkeeper-webserver-jetty9]
                                  [puppetlabs/trapperkeeper-webserver-jetty9 :classifier "test"]
                                  ; transitive dependency
				  [org.clojure/tools.nrepl "0.2.13"]]}
             :testutils {:source-paths ^:replace  ["test"]}}

  :plugins [[lein-parent "0.3.1"]
            [puppetlabs/i18n "0.8.0"]]

  :classifiers  [["test" :testutils]]

  :test-paths ["test"]

  :deploy-repositories [["releases" ~(deploy-info "https://clojars.org/repo")]
                        ["snapshots" ~(deploy-info {:url "https://artifactory.delivery.puppetlabs.net/artifactory/clojure-snapshots__local/"
                                                    :username :env/nexus_jenkins_password
                                                    :password :env/nexus_jenkins_password
                                                    :sign-releases false})]])
